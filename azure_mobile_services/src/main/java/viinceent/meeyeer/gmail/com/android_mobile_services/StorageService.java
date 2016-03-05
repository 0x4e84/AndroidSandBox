/*
 Copyright 2013 Microsoft Corp

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package viinceent.meeyeer.gmail.com.android_mobile_services;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceJsonTable;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageService {
    private final String TAG = StorageService.class.getSimpleName();
    private MobileServiceJsonTable mTableTables;
    private MobileServiceJsonTable mTableTableRows;
    private MobileServiceJsonTable mTableContainers;
    private MobileServiceJsonTable mTableBlobs;
    private Context mContext;
    private List<Map<String, String>> mTables;
    private ArrayList<JsonElement> mTableRows;
    private List<Map<String, String>> mContainers;
    private List<Map<String, String>> mBlobNames;
    private ArrayList<JsonElement> mBlobObjects;
    private JsonObject mLoadedBlob;

    /**
     * Initialize our service
     *
     * @param context -
     */
    public StorageService(Context context) {
        Log.d(TAG, "Entering StorageService");
        mContext = context;
        String url = context.getString(R.string.service_url);
        String key = context.getString(R.string.service_application_key);
        String tables = context.getString(R.string.service_tables);
        String rows = context.getString(R.string.service_rows);
        String containers = context.getString(R.string.service_containers);
        String blobs = context.getString(R.string.service_blobs);

        try {
            MobileServiceClient mClient = new MobileServiceClient(url, key, mContext);
            mTableTables = mClient.getTable(tables);
            mTableTableRows = mClient.getTable(rows);
            mTableContainers = mClient.getTable(containers);
            mTableBlobs = mClient.getTable(blobs);
        } catch (MalformedURLException e) {
            Log.e(TAG, "There was an error creating the Mobile Service. Verify the URL");
        }
    }

    public List<Map<String, String>> getLoadedTables() {
        Log.d(TAG, "Entering getLoadedTables");
        return this.mTables;
    }

    public JsonElement[] getLoadedTableRows() {
        Log.d(TAG, "Entering getLoadedTableRows");
        return this.mTableRows.toArray(new JsonElement[this.mTableRows.size()]);
    }

    public List<Map<String, String>> getLoadedContainers() {
        Log.d(TAG, "Entering getLoadedContainers");
        return this.mContainers;
    }

    public List<Map<String, String>> getLoadedBlobNames() {
        Log.d(TAG, "Entering getLoadedBlobNames");
        return this.mBlobNames;
    }

    public JsonElement[] getLoadedBlobObjects() {
        Log.d(TAG, "Entering getLoadedBlobObjects");
        return this.mBlobObjects.toArray(new JsonElement[this.mBlobObjects.size()]);
    }

    public JsonObject getLoadedBlob() {
        Log.d(TAG, "Entering getLoadedBlob");
        return this.mLoadedBlob;
    }

    /**
     * Fetches all of the tables from storage
     */
    public void getTables() {
        Log.d(TAG, "Entering getTables");
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    JsonElement result = mTableTables.where().execute().get();
                    JsonArray results = result.getAsJsonArray();

                    mTables = new ArrayList<>();
                    //Loop through the results and get the name of each table
                    for (JsonElement item : results) {
                        Map<String, String> map = new HashMap<>();
                        map.put("TableName", item.getAsJsonObject().getAsJsonPrimitive("TableName").getAsString());
                        mTables.add(map);
                    }
                    //Broadcast that tables have been loaded
                    Intent broadcast = new Intent();
                    broadcast.setAction("tables.loaded");
                    mContext.sendBroadcast(broadcast);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Adds a new table
     *
     * @param tableName -
     */
    public void addTable(String tableName) {
        Log.d(TAG, "Entering addTable");
        final JsonObject newTable = new JsonObject();
        newTable.addProperty("tableName", tableName);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableTables.insert(newTable).get();
                    //Refetch the tables from the server
                    getTables();
                } catch (Exception e) {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Handles deleting a table from storage
     *
     * @param tableName -
     */
    public void deleteTable(String tableName) {
        Log.d(TAG, "Entering deleteTable");
        //Create the json Object we'll send over and fill it with the required
        //id property - otherwise we'll get kicked back
        final JsonObject table = new JsonObject();
        table.addProperty("id", 0);
        //Create parameters to pass in the table name.  We do this with params
        //because it would be stripped out if we put it on the table object
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("tableName", tableName));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableTables.delete(table, parameters);
                    //Refetch the tables from the server
                    getTables();
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Gets all of the rows for a specific table
     *
     * @param tableName -
     */
    public void getTableRows(final String tableName) {
        Log.d(TAG, "Entering getTableRows");
        //Executes a read request with parameters
        //We have to do it in this way to ensure it shows up correctly on the server
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    JsonElement result = mTableTableRows.execute(mTableTableRows.parameter("table", tableName)).get();
                    JsonArray results = result.getAsJsonArray();
                    mTableRows = new ArrayList<>();

                    for (int i = 0; i < results.size(); i++) {
                        JsonElement item = results.get(i);
                        mTableRows.add(item);
                    }
                    //Broadcast that table rows have been loaded
                    Intent broadcast = new Intent();
                    broadcast.setAction("tablerows.loaded");
                    mContext.sendBroadcast(broadcast);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Deletes an individual table row
     *
     * @param tableName -
     * @param partitionKey -
     * @param rowKey -
     */
    public void deleteTableRow(final String tableName, String partitionKey, String rowKey) {
        Log.d(TAG, "Entering deleteTableRow");
        //Create the json Object we'll send over and fill it with the required
        //id property - otherwise we'll get kicked back
        final JsonObject row = new JsonObject();
        row.addProperty("id", 0);
        //Create parameters to pass in the table row details.  We do this with params
        //because it would be stripped out if we put it on the row object
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("tableName", tableName));
        parameters.add(new Pair<>("rowKey", rowKey));
        parameters.add(new Pair<>("partitionKey", partitionKey));


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableTableRows.delete(row, parameters).get();
                    getTableRows(tableName);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Adds a new row to a table
     *
     * @param tableName -
     * @param tableRowData -
     */
    public void addTableRow(final String tableName, List<Pair<String, String>> tableRowData) {
        Log.d(TAG, "Entering addTableRow");
        //Create a new json object with the key value pairs
        final JsonObject newRow = new JsonObject();
        for (Pair<String, String> pair : tableRowData) {
            newRow.addProperty(pair.first, pair.second);
        }
        //Pass the table name over in parameters
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("table", tableName));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableTableRows.insert(newRow, parameters).get();
                    //Refetch the table rows from the server
                    getTableRows(tableName);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Updates an existing table row
     *
     * @param tableName -
     * @param tableRowData -
     */
    public void updateTableRow(final String tableName, List<Pair<String, String>> tableRowData) {
        Log.d(TAG, "Entering updateTableRow");
        //Create a new json object with the key value pairs
        final JsonObject newRow = new JsonObject();
        for (Pair<String, String> pair : tableRowData) {
            newRow.addProperty(pair.first, pair.second);
        }
        //Add ID Parameter since it's required on the server side
        newRow.addProperty("id", 1);
        //Pass the table name over in parameters
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("table", tableName));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableTableRows.update(newRow, parameters).get();
                    //Refetch the table rows from the server
                    getTableRows(tableName);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Gets all of the containers from storage
     */
    public void getContainers() {
        Log.d(TAG, "Entering getContainers");
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    JsonElement result = mTableContainers.where().execute().get();
//                    JsonElement result = mTableContainers.where().field("containerName").eq("test").execute().get();
                    JsonArray results = result.getAsJsonArray();
                    mContainers = new ArrayList<>();
                    for (int i = 0; i < results.size(); i++) {
                        JsonElement item = results.get(i);
                        JsonElement namePrimitive = item.getAsJsonObject().getAsJsonPrimitive("name");
                        if (namePrimitive != null) {
                            Map<String, String> map = new HashMap<>();
                            map.put("ContainerName", namePrimitive.getAsString());
                            mContainers.add(map);
                        }
                    }
                    //Broadcast that the containers have been loaded
                    Intent broadcast = new Intent();
                    broadcast.setAction("containers.loaded");
                    mContext.sendBroadcast(broadcast);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Adds a new container
     *
     * @param containerName -
     * @param isPublic      - specifies if the container should be public or not
     */
    public void addContainer(String containerName, boolean isPublic) {
        Log.d(TAG, "Entering addContainer");
        //Creating a json object with the container name
        final JsonObject newContainer = new JsonObject();
        newContainer.addProperty("containerName", containerName);
        //Passing over the public flag as a parameter
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("isPublic", isPublic ? "1" : "0"));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableContainers.insert(newContainer, parameters).get();
                    //Refetch the containers from the server
                    getContainers();
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Deletes a container
     *
     * @param containerName -
     */
    public void deleteContainer(String containerName) {
        Log.d(TAG, "Entering deleteContainer");
        //Create the json Object we'll send over and fill it with the required
        //id property - otherwise we'll get kicked back
        final JsonObject container = new JsonObject();
        container.addProperty("id", 0);
        //Create parameters to pass in the container details.  We do this with params
        //because it would be stripped out if we put it on the container object
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("containerName", containerName));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableContainers.delete(container, parameters).get();
                    //Refetch containers from the server
                    getContainers();
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Get all of the blobs for a container
     *
     * @param containerName -
     */
    public void getBlobsForContainer(final String containerName) {
        Log.d(TAG, "Entering getBlobsForContainer");
        //Pass the container name as a parameter
        //We have to do it in this way for it to show up properly on the server

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    JsonElement result = mTableBlobs.execute(mTableBlobs.parameter("container", containerName)).get();
                    JsonArray results = result.getAsJsonArray();
                    //Store a local array of both the JsonElements and the blob names
                    mBlobNames = new ArrayList<>();
                    mBlobObjects = new ArrayList<>();
                    for (int i = 0; i < results.size(); i++) {
                        JsonElement item = results.get(i);
                        mBlobObjects.add(item);
                        Map<String, String> map = new HashMap<>();
                        map.put("BlobName", item.getAsJsonObject().getAsJsonPrimitive("name").getAsString());
                        mBlobNames.add(map);
                    }
                    //Broadcast that blobs are loaded
                    Intent broadcast = new Intent();
                    broadcast.setAction("blobs.loaded");
                    mContext.sendBroadcast(broadcast);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Handles deleting a blob
     *
     * @param containerName -
     * @param blobName -
     */
    public void deleteBlob(final String containerName, String blobName) {
        Log.d(TAG, "Entering deleteBlob");
        //Create the json Object we'll send over and fill it with the required
        //id property - otherwise we'll get kicked back
        final JsonObject blob = new JsonObject();
        blob.addProperty("id", 0);
        //Create parameters to pass in the blob details.  We do this with params
        //because it would be stripped out if we put it on the blob object
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("containerName", containerName));
        parameters.add(new Pair<>("blobName", blobName));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    mTableBlobs.delete(blob, parameters).get();
                    //Refetch the blobs from the server
                    getBlobsForContainer(containerName);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Gets a SAS URL for an existing blob
     *
     * @param containerName -
     * @param blobName      NOTE THIS IS DONE AS A SEPARATE METHOD FROM getSasForNewBlob BECAUSE IT
     *                      BROADCASTS A DIFFERENT ACTION
     */
    public void getBlobSas(String containerName, String blobName) {
        Log.d(TAG, "Entering getBlobSas");
        //Create the json Object we'll send over and fill it with the required
        //id property - otherwise we'll get kicked back
        final JsonObject blob = new JsonObject();
        blob.addProperty("id", 0);
        //Create parameters to pass in the blob details.  We do this with params
        //because it would be stripped out if we put it on the blob object
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("containerName", containerName));
        parameters.add(new Pair<>("blobName", blobName));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    JsonElement result = mTableBlobs.insert(blob, parameters).get();
                    //Set the loaded blob
                    mLoadedBlob = result.getAsJsonObject();
                    //Broadcast that the blob is loaded
                    Intent broadcast = new Intent();
                    broadcast.setAction("blob.loaded");
                    mContext.sendBroadcast(broadcast);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    /**
     * Gets a SAS URL for a new blob so we can upload it to the server
     *
     * @param containerName Container name
     * @param blobName Blob name
     */
    public void getSasForNewBlob(String containerName, String blobName) {
        Log.d(TAG, "Entering getSasForNewBlob");
        //Create the json Object we'll send over and fill it with the required
        //id property - otherwise we'll get kicked back
        final JsonObject blob = new JsonObject();
        blob.addProperty("id", 0);
        //Create parameters to pass in the blob details.  We do this with params
        //because it would be stripped out if we put it on the blob object
        final List<Pair<String, String>> parameters = new ArrayList<>();
        parameters.add(new Pair<>("containerName", containerName));
        parameters.add(new Pair<>("blobName", blobName));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try
                {
                    JsonElement result = mTableBlobs.insert(blob, parameters).get();
                    //Set the loaded blob
                    mLoadedBlob = result.getAsJsonObject();
                    //Broadcast that we are ready to upload the blob data
                    Intent broadcast = new Intent();
                    broadcast.setAction("blob.created");
                    mContext.sendBroadcast(broadcast);
                } catch (Exception e)
                {
                    Log.e(TAG, e.getCause().getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }
}

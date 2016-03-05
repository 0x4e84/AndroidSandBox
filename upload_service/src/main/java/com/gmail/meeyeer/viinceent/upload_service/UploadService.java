package com.gmail.meeyeer.viinceent.upload_service;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class UploadService extends IntentService {

    private static final String TAG = UploadService.class.getSimpleName();
    private int result = Activity.RESULT_CANCELED;
    public static final String RESULT = "result";
    public static final String CONNECTIVITY = "unknown";
    public static final String NOTIFICATION = "com.gmail.meeyeer.viinceent.upload_service";

    public UploadService() {
        super("UploadService");
    }

    // will be called asynchronously by Android
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "Handling UploadService intent");
        if (isConnectionAvailable()) {
            // successfully finished
            result = Activity.RESULT_OK;

            Log.d(TAG, "Connectivity is available!");
            publishResults("Connectivity is available", result);
        } else {
            Log.d(TAG, "Connectivity is NOT available!");
            publishResults("Connectivity is not available", result);
        }
    }

    private void publishResults(String connectivity, int result) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(CONNECTIVITY, connectivity);
        intent.putExtra(RESULT, result);
        sendBroadcast(intent);
    }

    private boolean isConnectionAvailable() {
//        ConnectivityManager conMgr = (ConnectivityManager)
//                getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo i = conMgr.getActiveNetworkInfo();
//        if (i == null)
//            return false;
//        if (!i.isConnected())
//            return false;
//        if (!i.isAvailable())
//            return false;
        return true;
    }
}
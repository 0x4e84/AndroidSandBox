/***
 Copyright (c) 2008-2012 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.

 From _The Busy Coder's Guide to Android Development_
 http://commonsware.com/Android
 */

package com.gmail.meeyeer.viinceent.upload_service;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView textView;

//    private BroadcastReceiver receiver = new BroadcastReceiver() {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Log.d(TAG, "Receiving a broadcast");
//            Bundle bundle = intent.getExtras();
//            if (bundle != null) {
//                String connectivity = bundle.getString(UploadService.CONNECTIVITY);
//                int resultCode = bundle.getInt(UploadService.RESULT);
//
//                if (resultCode == RESULT_OK) {
//                    Toast.makeText(MainActivity.this,
//                            "Upload successful. Connectivity status:" + connectivity,
//                            Toast.LENGTH_LONG).show();
//                    textView.setText("Download done");
//                } else {
//                    Toast.makeText(MainActivity.this,
//                            "Upload not successful. Connectivity status:" + connectivity,
//                            Toast.LENGTH_LONG).show();
//                    textView.setText("Download failed");
//                }
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
//            getFragmentManager().beginTransaction()
//                    .add(android.R.id.content,
//                            new com.gmail.meeyeer.viinceent.downloadservice.DownloadFragment()).commit();
//        }

        Log.d(TAG, "onCreate");
        textView = (TextView) findViewById(R.id.status);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
//        registerReceiver(receiver, new IntentFilter(UploadService.NOTIFICATION));
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
//        unregisterReceiver(receiver);
    }

    public void onClick(View view) {
        Log.d(TAG, "onClick");
//        Intent intent = new Intent(this, UploadService.class);
//        startService(intent);
        textView.setText("Service started");

    }
}
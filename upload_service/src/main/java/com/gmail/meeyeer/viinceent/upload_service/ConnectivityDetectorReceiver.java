package com.gmail.meeyeer.viinceent.upload_service;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ConnectivityDetectorReceiver extends BroadcastReceiver {

    private static final String TAG = ConnectivityDetectorReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Receiving Connectivity Broadcast!");
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null) {
            final android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            final android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (wifi.isAvailable()) {
                Log.d(TAG, "WiFi is available");
            }
            if (mobile.isAvailable()) {
                Log.d(TAG, "Mobile connection is available");
            }

            if (info.isConnected()) {
                // you got a connection! tell your user!
                Log.d(TAG, "Connected!");
                Intent intent_service=new Intent(context, UploadService.class);
                context.startService(intent_service);
            } else {
                Log.d(TAG, "Not connected");
            }
        } else {
            Log.d(TAG, "NetworkInfo is null!");
        }
    }
}

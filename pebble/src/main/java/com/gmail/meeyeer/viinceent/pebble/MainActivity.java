package com.gmail.meeyeer.viinceent.pebble;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.getpebble.android.kit.Constants.*;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private PebbleKit.PebbleDataReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        Button notificationButton = (Button)findViewById(R.id.notification_button);
        if (notificationButton != null) {
            notificationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pushPebbleNotification();
                }
            });
        }

        Button launchButton = (Button)findViewById(R.id.launch_sport_button);
        if (launchButton != null) {
            launchButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();

                    boolean isConnected = PebbleKit.isWatchConnected(context);

                    if(isConnected) {
                        // Launch the sports app
                        PebbleKit.startAppOnPebble(context, SPORTS_UUID);

                        Toast.makeText(context, R.string.dialog_launching, Toast.LENGTH_SHORT).show();

                        // Send data 5s after launch
                        mHandler.postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                // Send a time and distance to the sports app
                                PebbleDictionary outgoing = new PebbleDictionary();
                                outgoing.addString(SPORTS_TIME_KEY, "12:52");
                                outgoing.addString(SPORTS_DISTANCE_KEY, "23.8");
                                outgoing.addUint8(SPORTS_UNITS_KEY,
                                        (byte) SPORTS_UNITS_METRIC);
                                outgoing.addUint8(SPORTS_LABEL_KEY,
                                        (byte) SPORTS_DATA_SPEED);
                                // outgoing.addUint8(SPORTS_LABEL_KEY, (byte) SPORTS_DATA_PACE);
                                outgoing.addString(SPORTS_DATA_KEY, "6.28");
                                PebbleKit.sendDataToPebble(getApplicationContext(),
                                        SPORTS_UUID, outgoing);
                            }

                        }, 5000L);

                    } else {
                        Toast.makeText(context, R.string.dialog_not_connected, Toast.LENGTH_LONG).show();
                    }
                }

            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Get information back from the watchapp
        if(mReceiver == null) {
            mReceiver = new PebbleKit.PebbleDataReceiver(SPORTS_UUID) {

                @Override
                public void receiveData(Context context, int id, PebbleDictionary data) {
                    // Always ACKnowledge the last message to prevent timeouts
                    PebbleKit.sendAckToPebble(getApplicationContext(), id);

                    // Get action and display
                    int state = data.getUnsignedIntegerAsLong(SPORTS_STATE_KEY).intValue();
                    Toast.makeText(getApplicationContext(),
                            ((state == SPORTS_STATE_PAUSED) ? "Resumed!" : "Paused!"),
                            Toast.LENGTH_SHORT).show();
                }

            };
        }

        // Register the receiver to get data
        PebbleKit.registerReceivedDataHandler(this, mReceiver);

        getPebbleStatus();
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

    private void getPebbleStatus() {
        StringBuilder builder = new StringBuilder();
        boolean isConnected = PebbleKit.isWatchConnected(this);
        boolean isAppMessageSupported = PebbleKit.areAppMessagesSupported(this);
        PebbleKit.FirmwareVersionInfo info = PebbleKit.getWatchFWVersion(this);

        builder.append("Pebble Info\n\n")
                .append(String.format("Watch is%s connected.\n", isConnected ?
                        "" : " not"))
                .append(String.format("AppMessage is%s supported.\n", isAppMessageSupported ?
                        "" : " not"))
                .append(String.format("Firmware version: %s.%s.\n",
                        info.getMajor(), info.getMinor()));

        TextView textView = (TextView)findViewById(R.id.pebble_status);
        if (textView != null) {
            textView.setText(builder.toString());
        }
    }

    public void pushPebbleNotification() {
        final Intent i = new Intent("com.getpebble.action.SEND_NOTIFICATION");
        final Map<String, String> data = new HashMap<>();
        data.put("title", "Test message");
        data.put("body", "Whoever said nothing was impossible never tried to slam a revolving door.");
        final JSONObject jsonData = new JSONObject(data);
        final String notificationData = new JSONArray().put(jsonData).toString();

        i.putExtra("messageType", "PEBBLE_ALERT");
        i.putExtra("sender", "PebbleKit Android");
        i.putExtra("notificationData", notificationData);
        sendBroadcast(i);
    }
}

package com.gmail.meeyeer.viinceent.androidsandbox.debug;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gmail.meeyeer.viinceent.androidsandbox.BuildConfig;
import com.gmail.meeyeer.viinceent.androidsandbox.PreferencesFragment;
import com.gmail.meeyeer.viinceent.androidsandbox.R;
import com.gmail.meeyeer.viinceent.androidsandbox.SettingsActivity;
import com.google.android.material.snackbar.Snackbar;

public class DebugActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = DebugActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        Button testButton;
        testButton = findViewById(R.id.button_debug);
        testButton.setOnClickListener(this);

        Button snackButton;
        snackButton = findViewById(R.id.button_snackbar);
        snackButton.setOnClickListener(this);
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.d(TAG, "Touch detected on AppCompatActivity");
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_debug, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Show the Debug Page if the App is running in Debug mode
        MenuItem debugPageItem = menu.findItem(R.id.action_debug);
        debugPageItem.setVisible(BuildConfig.DEBUG);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_debug:
                Log.d(TAG, "Debug test button has been pressed!");

                Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                settingsIntent.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT,
                        PreferencesFragment.class.getName());
                settingsIntent.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true);
                startActivity(settingsIntent);

                break;
            case R.id.button_snackbar:
                Snackbar snackbar;

                snackbar = Snackbar.make(findViewById(R.id.debug_fragment),
                        "Snackbar button has been pressed!", Snackbar.LENGTH_LONG);
//                snackbar.getView().setOnDragListener(new View.OnDragListener() {
//                    @Override
//                    public boolean onDrag(View v, DragEvent event) {
//                        Log.d(TAG, "Dragging the snackbar");
//                        return true;
//                    }
//                });
//                snackbar.getView().setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        Log.d(TAG, "Touching the snackbar");
//                        return false;
//                    }
//                });
                snackbar.show();
                break;
        }
    }
}

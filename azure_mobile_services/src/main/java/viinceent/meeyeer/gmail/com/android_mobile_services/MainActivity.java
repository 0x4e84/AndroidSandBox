package viinceent.meeyeer.gmail.com.android_mobile_services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the UI elements
        Button btnTableStorage = (Button) findViewById(R.id.btnTableStorage);
        Button btnBlobButton = (Button) findViewById(R.id.btnBlobStorage);
        //Set click listeners to launch activities
        btnTableStorage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TablesActivity.class);
//                Intent intent = new Intent(MainActivity.this, DummyActivity.class);
                v.getContext().startActivity(intent);
                //startActivity(new Intent(getApplicationContext(), TablesActivity.class));
            }
        });
        btnBlobButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContainersActivity.class);
                v.getContext().startActivity(intent);
                //startActivity(new Intent(getApplicationContext(), ContainersActivity.class));
            }
        });
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
}

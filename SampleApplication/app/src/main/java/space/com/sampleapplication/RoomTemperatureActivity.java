package space.com.sampleapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class RoomTemperatureActivity extends Activity {

    public static final String KEY_NAME = "key_name";

    private static final String TAG = "RoomTemperatureActivity";

    private TextView username, temperature;

    private BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float batteryPercentage = level / (float) scale * 100;

            temperature.setText(Float.toString(batteryPercentage));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_temperature);

        String name = getIntent().getStringExtra(KEY_NAME);
        if (name == null) {
            Log.e(TAG, "onCreate: username not passed! ");
        } else {
            initUi(name);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }


    @Override
    protected void onStop() {
        if (batteryReceiver != null) {
            unregisterReceiver(batteryReceiver);
        }
        super.onStop();
    }

    private void initUi(String name) {
        username = (TextView) findViewById(R.id.username);
        temperature = (TextView) findViewById(R.id.temperature);

        username.setText(name);
    }
}

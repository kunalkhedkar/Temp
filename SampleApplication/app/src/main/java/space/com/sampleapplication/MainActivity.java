package space.com.sampleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    private void initUi() {
        userName = (EditText) findViewById(R.id.name);
    }

    public void onStartButtonClick(View view) {
        String name = userName.getText().toString().trim();
        startTemperatureActivity(name);
    }

    private void startTemperatureActivity(String name) {
        Log.d(TAG, "startTemperatureActivity() called with: name = [" + name + "]");

        Intent temperatureActivity = new Intent(this, RoomTemperatureActivity.class);
        temperatureActivity.putExtra(RoomTemperatureActivity.KEY_NAME, name);
        startActivity(temperatureActivity);
    }
}

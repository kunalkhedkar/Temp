package space.com.sampleapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TemperatureReceiver extends BroadcastReceiver {
    private static final String TAG = "TemperatureReceiver";

    public TemperatureReceiver() {
        Log.d(TAG, "TemperatureReceiver");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        startAlertService(context);
    }

    private void startAlertService(Context context) {
        Intent alertService = new Intent(context, AlertService.class);
        context.startService(alertService);
    }
}

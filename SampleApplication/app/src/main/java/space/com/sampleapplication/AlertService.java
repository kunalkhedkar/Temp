package space.com.sampleapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

public class AlertService extends Service {

    public static final String TAG = "AlertService";

    public AlertService() {
        Log.d(TAG, "AlertService: ");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(this, Uri.parse("/mnt/sdcard/notification.mp3"));
            mediaPlayer.prepare();
        } catch (IOException e) {
            Log.e(TAG, "onStartCommand: ", e);
        }

        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

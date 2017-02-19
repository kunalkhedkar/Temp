package edu.self.fragmentdemov4;

import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity implements SongsListFragment.OnRingtoneSelected {

    private PlaybackFragment playbackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        FragmentManager fragmentManager = getFragmentManager();
        playbackFragment = (PlaybackFragment) fragmentManager.findFragmentById(R.id.fragment_playback);
    }

    @Override
    public void onRingtoneSelected(Uri uri) {
        // play the ringtone
        if (playbackFragment != null) {
            playbackFragment.play(uri);
        }
    }
}

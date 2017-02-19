package edu.self.fragmentdemov4;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akshay on 19/02/2017.
 */

public class PlaybackFragment extends Fragment {

    private View view;
    private MediaPlayer player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playback, container, false);
        return view;
    }

    public void play(Uri uri) {
        playMedia(uri);
    }

    private void playMedia(Uri uri) {
        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
                player.release();
                player = null;
            }
        }
        player = MediaPlayer.create(getActivity(), uri);
        player.start();
    }

}

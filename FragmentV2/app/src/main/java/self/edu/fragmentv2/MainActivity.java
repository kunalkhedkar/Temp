package self.edu.fragmentv2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSongListButtonClick(View view) {
        SongsListFragment songsListFragment = new SongsListFragment();
        addFragment(songsListFragment);
    }

    public void onPlaybackButtonClick(View view) {
        PlaybackFragment playbackFragment = new PlaybackFragment();
        addFragment(playbackFragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    public void onSubtractButtonClick(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
//        Fragment fragment = fragmentManager.findFragmentByTag(SongsListFragment.class.getName());
        if (fragment != null) {
            fragmentTransaction.remove(fragment).commit();
        } else {
            Toast.makeText(this, "No Fragments Added", Toast.LENGTH_SHORT).show();
        }

    }
}

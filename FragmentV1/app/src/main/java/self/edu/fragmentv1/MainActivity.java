package self.edu.fragmentv1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragments();
    }

    private void initFragments() {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        SongListFragment songListFragment = new SongListFragment();

        fragmentTransaction.add(R.id.fragment_container, songListFragment);

        fragmentTransaction.commit();
    }

    public void onStartButtonClick(View view) {
        Toast.makeText(this, "Start button clicked!", Toast.LENGTH_SHORT).show();

        FragmentTransaction playbackTransaction = getFragmentManager().beginTransaction();

        PlaybackFragment playbackFragment = new PlaybackFragment();
        playbackTransaction.add(R.id.fragment_container, playbackFragment);

        playbackTransaction.commit();
    }
}

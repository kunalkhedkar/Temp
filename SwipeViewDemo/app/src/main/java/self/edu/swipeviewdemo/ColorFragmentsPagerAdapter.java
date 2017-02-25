package self.edu.swipeviewdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by imran on 25/2/17.
 */

public class ColorFragmentsPagerAdapter extends FragmentPagerAdapter {

    // class ColorFragmentsPagerAdapter extends FragmentStatePagerAdapter
    
    public ColorFragmentsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentR();
                break;
            case 1:
                fragment = new FragmentG();
                break;
            case 2:
                fragment = new FragmentB();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title = "";
        switch (position) {
            case 0:
                title = "RED";
                break;
            case 1:
                title = "GREEN";
                break;
            case 2:
                title = "BLUE";
                break;

        }
        return title;
    }
}

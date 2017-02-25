package self.edu.swipeviewdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {


    private ColorFragmentsPagerAdapter adapter;
    private ViewPager viewPger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    private void initUi() {

        viewPger = (ViewPager) findViewById(R.id.pager);

        adapter = new ColorFragmentsPagerAdapter(getSupportFragmentManager());

        viewPger.setAdapter(adapter);
    }
}

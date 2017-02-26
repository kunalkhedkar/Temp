package self.edu.navigationdrawerdemo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private ListView drawerList;
    private String[] app_features;
    private DrawerLayout drawerLayout;

    private final static String TAG = "DrawerDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();

        initDrawer();
    }

    private void initUi() {
        drawerList = (ListView) findViewById(R.id.drawer_list);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initDrawer() {
        initDrawerListView();
    }

    private void initDrawerListView() {
        // populate drawer list
        app_features = getResources().getStringArray(R.array.app_features);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, app_features);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new DrawerListItemClickListener());
    }

    class DrawerListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(getApplicationContext(), app_features[position], Toast.LENGTH_SHORT).show();
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        Log.d(TAG, "selectItem() called with: position = [" + position + "]");
        String folerName = app_features[position];
        replaceFragment(folerName);
        drawerList.setItemChecked(position, true);
        drawerLayout.closeDrawer(drawerList);
    }

    private void replaceFragment(String folerName) {
        Log.d(TAG, "replaceFragment() called with: folerName = [" + folerName + "]");

        // create a Fragment
        EmailFolderFragment fragment = new EmailFolderFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EmailFolderFragment.KEY_FOLDER_NAME, folerName);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }
}

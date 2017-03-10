package self.edu.adapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends Activity {

    private String[] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateDataSet();
        populateListView();
    }

    private void populateListView() {
        //ListView  listView = (ListView) findViewById(R.id.days_list);
        //GridView listView = (GridView) findViewById(R.id.days_list);
        Gallery listView = (Gallery) findViewById(R.id.days_list);
        DaysAdapter adapter = new DaysAdapter(days);
        listView.setAdapter(adapter);
    }

    private void populateDataSet() {
        days = getResources().getStringArray(R.array.days_of_week);
    }
}

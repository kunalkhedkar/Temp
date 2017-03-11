package self.edu.simpleadapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    private ArrayList<HashMap<String, String>> data;

    private final String[] FROM = new String[]{"SR_NO", "NAME", "GRADE"};
    private final int[] TO = new int[]{R.id.sr_no, R.id.name, R.id.grade};

    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();

    }

    private void populateListView() {
        data = populateData();

        ListView listView = (ListView) findViewById(R.id.list);
        adapter = new SimpleAdapter(this, data, R.layout.list_item, FROM, TO) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO
                return super.getView(position, convertView, parent);
            }
        };
        listView.setAdapter(adapter);
    }

    private ArrayList<HashMap<String, String>> populateData() {

        ArrayList<HashMap<String, String>> data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            HashMap<String, String> row = new HashMap<>();
            row.put(FROM[0], String.valueOf(i));
            row.put(FROM[1], String.valueOf(i));
            row.put(FROM[2], String.valueOf(i + 0.1));

            data.add(row);
        }

        return data;
    }

    public void onChangeDataButtonClick(View view) {
        // change data
        if (data.size() > 0) {
            data.remove(data.size() - 1);
            adapter.notifyDataSetChanged();
        } else {
            HashMap<String, String> row = new HashMap<>();
            row.put(FROM[0], String.valueOf(9));
            row.put(FROM[1], String.valueOf(9));
            row.put(FROM[2], String.valueOf(9 + 0.1));

            data.add(row);

            adapter.notifyDataSetChanged();
        }
    }

}

package self.edu.simplecursoradapterdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Random;

public class MainActivity extends Activity {

    private final static String DB_NAME = "student_database.db";
    private static final String TAG = "simp-cursoradp_demo";
    private SQLiteDatabase database;

    private ListView listView;
    private final String[] FROM = new String[]{"roll_no", "name"};
    private final int[] TO = new int[]{R.id.roll_no, R.id.name};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatabase();
        initListView();
    }

    private void initListView() {
        listView = (ListView) findViewById(R.id.list);
    }

    private void initDatabase() {
        DatabaseHelper helper = new DatabaseHelper(this, DB_NAME, null, 1);
        database = helper.getWritableDatabase();
    }

    public void onClick_AddDataToDatabaseButton(View view) {
        Random random = new Random();

        ContentValues student = new ContentValues();
        student.put("_id", random.nextInt(1000));
        student.put("name", "Tanay");
        student.put("roll_no", random.nextInt(50));

        long count = database.insert("tbl_student", null, student);
        Log.d(TAG, "onClick_AddDataToDatabaseButton()= [" + count + "]");
    }

    public void onClick_LoadDataFromDatabaseButton(View view) {

        Cursor cursor = database.rawQuery("SELECT * FROM tbl_student", null);

        SimpleCursorAdapter simpleCursorAdapter = new
                SimpleCursorAdapter(this, R.layout.list_item, cursor, FROM, TO);
        listView.setAdapter(simpleCursorAdapter);
    }

}

package self.edu.cursoradapterdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Random;

public class MainActivity extends Activity {

    private final static String DB_NAME = "student_database.db";
    private static final String TAG = "cursor_adapter_demo";
    private SQLiteDatabase database;

    private ListView listView;
    private StudentCursorAdapter studentCursorAdapter;
    private Cursor studentCursor;

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
        student.put("_id", random.nextInt(100));
        student.put("name", "Kunal");
        student.put("roll_no", random.nextInt(40));

        long count = database.insert("tbl_student", null, student);
        Log.d(TAG, "onClick_AddDataToDatabaseButton(): count = [" + count + "]");
    }

    public void onClick_LoadDataFromDatabaseButton(View view) {
        studentCursor = database.rawQuery("SELECT * FROM tbl_student", null);
        studentCursorAdapter = new StudentCursorAdapter(this, studentCursor, CursorAdapter.FLAG_AUTO_REQUERY);
        listView.setAdapter(studentCursorAdapter);
    }

}

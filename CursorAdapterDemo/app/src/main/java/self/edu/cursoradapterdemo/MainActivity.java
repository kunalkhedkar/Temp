package self.edu.cursoradapterdemo;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private final static String DB_NAME = "student_database.db";
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatabase();
    }

    private void initDatabase() {
        DatabaseHelper helper = new DatabaseHelper(this, DB_NAME, null, 1);
        database = helper.getWritableDatabase();
    }

    public void onClick_AddDataToDatabaseButton(View view) {
    }

    public void onClick_LoadDataFromDatabaseButton(View view) {
    }

}

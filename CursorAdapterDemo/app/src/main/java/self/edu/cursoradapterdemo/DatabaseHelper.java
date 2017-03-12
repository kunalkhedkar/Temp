package self.edu.cursoradapterdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by imran on 11/3/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String CREATE_TABLE_STUDENT_QUERY =
            "create table tbl_student(_id int,name string, roll_no integer)";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_STUDENT_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Do Nothing
    }
}

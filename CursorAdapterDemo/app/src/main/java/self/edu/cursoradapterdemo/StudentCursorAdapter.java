package self.edu.cursoradapterdemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by imran on 12/3/17.
 */

public class StudentCursorAdapter extends CursorAdapter {
    public StudentCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final int rollNumber = cursor.getInt(cursor.getColumnIndex("roll_no"));
        final String name = cursor.getString(cursor.getColumnIndex("name"));
        TextView text_roll_number = (TextView) view.findViewById(R.id.roll_no);
        TextView text_name = (TextView) view.findViewById(R.id.name);

        text_roll_number.setText(String.valueOf(rollNumber));
        text_name.setText(name);
    }
}

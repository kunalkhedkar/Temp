package self.edu.adapterdemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by isolanki on 10-Mar-17.
 */

public class DaysAdapter extends BaseAdapter {

    private String[] days;

    public DaysAdapter(String[] days) {
        this.days = days;
    }

    @Override
    public int getCount() {
        return days.length;
    }

    @Override
    public Object getItem(int position) {
        return days[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String day = days[position];


        if (convertView == null) {
            View view = parent.inflate(parent.getContext(), R.layout.day_item, null);
            TextView textView = (TextView) view.findViewById(R.id.day);
            textView.setText(day);
            return view;
        } else {
            TextView textView = (TextView) convertView.findViewById(R.id.day);
            textView.setText(day);
            return convertView;
        }

    }
}

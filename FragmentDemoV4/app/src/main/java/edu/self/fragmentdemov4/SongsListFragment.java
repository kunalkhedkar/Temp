package edu.self.fragmentdemov4;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Akshay on 19/02/2017.
 */

public class SongsListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private Uri[] ringtones;

    private OnRingtoneSelected listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRingtoneSelected) {
            listener = (OnRingtoneSelected) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_songs_list, container, false);
        initUi();
        return view;
    }

    private void initUi() {
        ListView songsList = (ListView) view.findViewById(R.id.songs_list);
        ringtones = getAllRingtones();
        ArrayAdapter<Uri> adapter = new ArrayAdapter<Uri>(getActivity(), android.R.layout.simple_expandable_list_item_1, ringtones);
        songsList.setAdapter(adapter);

        songsList.setOnItemClickListener(this);
    }

    private Uri[] getAllRingtones() {
        RingtoneManager ringtoneManager = new RingtoneManager(getActivity());
        ringtoneManager.setType(RingtoneManager.TYPE_RINGTONE);

        Cursor cursor = ringtoneManager.getCursor();
        ArrayList<Uri> uris = new ArrayList<>();

        while (cursor.moveToNext()) {
            Uri uri = ringtoneManager.getRingtoneUri(cursor.getPosition());
            uris.add(uri);
        }
        return uris.toArray(new Uri[uris.size()]);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Uri selectedRingtone = ringtones[position];
        //Toast.makeText(getActivity(), "" + selectedRingtone, Toast.LENGTH_SHORT).show();
        listener.onRingtoneSelected(selectedRingtone);
    }


    public interface OnRingtoneSelected {
        void onRingtoneSelected(Uri uri);
    }
}

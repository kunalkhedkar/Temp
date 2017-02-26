package self.edu.navigationdrawerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by isolanki on 26-Feb-17.
 */

public class EmailFolderFragment extends Fragment {

    public static final java.lang.String KEY_FOLDER_NAME = "key_folder_name";
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_email_folder, container, false);
        // set the folder name
        String folder_name = "";
        Bundle bundle = getArguments();
        if (bundle != null) {
            folder_name = bundle.getString(KEY_FOLDER_NAME);
        }
        TextView textFolderName = (TextView) view.findViewById(R.id.folder_name);
        textFolderName.setText(folder_name);
        return view;
    }
}

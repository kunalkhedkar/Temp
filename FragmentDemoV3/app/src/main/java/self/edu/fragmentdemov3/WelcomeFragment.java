package self.edu.fragmentdemov3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by imran on 17/2/17.
 */

public class WelcomeFragment extends Fragment {

    public static final String EXTRA_AUTHENTICATED_EMAIL = "extra_authenticated_email";

    private View view;
    private String email;
    private TextView user_textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            email = bundle.getString(EXTRA_AUTHENTICATED_EMAIL);
        }
        user_textview = (TextView) view.findViewById(R.id.welcome_user);
        user_textview.setText("Welcome " + email);
    }
}

package self.edu.fragmentdemov3;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by imran on 17/2/17.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {

    public final static String EXTRA_LOGIN_EMAIL = "extra_login_email";
    public final static String EXTRA_LOGIN_PASSWORD = "extra_login_password";

    private View view;
    private String email, password;
    private TextView email_text, password_text;

    private onLoginSuccessful successListener;
    private onLoginFailure failureListener;
    private Button loginButton;

    public LoginFragment() {

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof onLoginSuccessful) {
            successListener = (onLoginSuccessful) activity;
        }
        if (activity instanceof onLoginFailure) {
            failureListener = (onLoginFailure) activity;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onLoginSuccessful) {
            successListener = (onLoginSuccessful) context;
        }
        if (context instanceof onLoginFailure) {
            failureListener = (onLoginFailure) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            // retrieve email,password
            email = bundle.getString(EXTRA_LOGIN_EMAIL);
            password = bundle.getString(EXTRA_LOGIN_PASSWORD);

            Toast.makeText(getActivity(), email, Toast.LENGTH_SHORT).show();


            email_text = (TextView) view.findViewById(R.id.login_email);
            password_text = (TextView) view.findViewById(R.id.login_password);

            email_text.setText(email);
            password_text.setText(password);

            loginButton = (Button) view.findViewById(R.id.btn_login);
            loginButton.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                // psudo code
                if (email_text.getText().toString().contains("gmail.com")) {
                    // valid user
                    successListener.onLoginSuccessful(email_text.getText().toString());
                } else {
                    // invalid user
                    failureListener.onLoginFailure();
                }
                break;
        }

    }

    public interface onLoginSuccessful {
        void onLoginSuccessful(String email);
    }

    public interface onLoginFailure {
        void onLoginFailure();
    }

}

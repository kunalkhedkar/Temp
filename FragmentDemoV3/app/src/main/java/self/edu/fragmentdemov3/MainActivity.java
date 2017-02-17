package self.edu.fragmentdemov3;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity implements LoginFragment.onLoginSuccessful, LoginFragment.onLoginFailure {

    private FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragments();
    }

    private void initFragments() {

        Bundle bundle = new Bundle();
        bundle.putString(LoginFragment.EXTRA_LOGIN_EMAIL, "imran@gmail.com");
        bundle.putString(LoginFragment.EXTRA_LOGIN_PASSWORD, "*****");

        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setArguments(bundle);
        replaceFragment(loginFragment);
    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container_frame, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @Override
    public void onLoginSuccessful(String email) {
        //Toast.makeText(this, "Login Successful. Wait...", Toast.LENGTH_LONG).show();
        WelcomeFragment welcomeFragment = new WelcomeFragment();

        Bundle bundle = new Bundle();
        bundle.putString(WelcomeFragment.EXTRA_AUTHENTICATED_EMAIL, email);
        welcomeFragment.setArguments(bundle);

        replaceFragment(welcomeFragment);
    }

    @Override
    public void onLoginFailure() {
        Toast.makeText(this, "Login Failed. User Gmail Account !", Toast.LENGTH_SHORT).show();
    }
}

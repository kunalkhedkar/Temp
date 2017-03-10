package self.edu.sharedpreferencesdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setTitle(getString(R.string.login));

        if (ApplicationSettings.getInstance(this).isLastUserAuthenticated()) {
            startWelcomeActivity();
        }
    }

    private void startWelcomeActivity() {
        Intent welcomeActivity = new Intent(this, WelcomeActivity.class);
        startActivity(welcomeActivity);
    }

    public void onButtonClick_Login(View view) {
        String emailId = ((TextView) findViewById(R.id.email)).getText().toString();
        String password = ((TextView) findViewById(R.id.password)).getText().toString();
        
        // Dummy Authentication
        if (emailId.equalsIgnoreCase(password)) {
            // valid user
            Toast.makeText(this, R.string.welcome, Toast.LENGTH_LONG).show();
            ApplicationSettings.getInstance(this).setUserAuthenticationAs(true);
            startWelcomeActivity();
        } else {
            ApplicationSettings.getInstance(this).setUserAuthenticationAs(false);
            // in valid user
            Toast.makeText(this, R.string.please_enter_correct_credentials, Toast.LENGTH_LONG).show();
        }
    }


}

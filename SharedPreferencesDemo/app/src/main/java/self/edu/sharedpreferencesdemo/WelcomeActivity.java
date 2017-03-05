package self.edu.sharedpreferencesdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by imran on 5/3/17.
 */
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        getActionBar().setTitle("Welcome Screen");
    }
}

package self.edu.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by imran on 5/3/17.
 */

public class ApplicationSettings {

    private static ApplicationSettings sThis = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String TAG = "sharedPref";
    private static final String KEY_IS_AUTHENTICATED = "KEY_IS_AUTHENTICATED";

    private ApplicationSettings(Context context) {
        sharedPreferences =
                context.getSharedPreferences(context.getString(R.string.shared_preferences_file_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    synchronized public static ApplicationSettings getInstance(Context context) {
        if (sThis == null) {
            sThis = new ApplicationSettings(context);
        }
        return sThis;
    }

    public boolean isLastUserAuthenticated() {
        // retrieve value from shared pref
        final boolean result = sharedPreferences.getBoolean(KEY_IS_AUTHENTICATED, false);
        Log.d(TAG, "isLastUserAuthenticated() returned: " + result);
        return result;
    }

    public void setUserAuthenticationAs(boolean isAuthenticated) {
        // store data in shared preferences

        // write data
        editor.putBoolean(KEY_IS_AUTHENTICATED, isAuthenticated);

        // commit data in shared pref
        editor.commit();
    }


}

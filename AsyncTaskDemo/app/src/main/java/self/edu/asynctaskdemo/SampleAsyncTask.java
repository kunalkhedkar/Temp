package self.edu.asynctaskdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by imran on 18/3/17.
 */

public class SampleAsyncTask extends AsyncTask<String, Void, Boolean> {


//    public class SampleAsyncTask extends AsyncTask<Void, Void, Void> {

    private final Context context;
    ProgressDialog progressDialog;

    public SampleAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(String... voids) {
        Log.d("***", "doInBackground: ThreadName=" + Thread.currentThread().getName());
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        progressDialog.dismiss();
        String message = (result == true) ? "Success Message" : "Failure Message";
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}

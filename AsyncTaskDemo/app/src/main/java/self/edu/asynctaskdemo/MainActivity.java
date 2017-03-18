package self.edu.asynctaskdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SampleAsyncTask sampleAsyncTask = new SampleAsyncTask(this);
        sampleAsyncTask.execute();

    }


    public void threadDemo() {
        Thread myThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //Do Nothing
                }
            }
        };
        myThread.start();
    }

    public void handlerDemo() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Title");
        dialog.setMessage("Sample Message");
        dialog.setCancelable(false);
        dialog.show();

//        try {
//            Thread.sleep(500 * 1000);
//        } catch (InterruptedException e) {
//            Log.e("***", "onResume: ", e);
//        }
//        dialog.dismiss();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 5 * 1000);
//        handler.post(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        //Write code
//                    }
//                }
//        );

    }
}

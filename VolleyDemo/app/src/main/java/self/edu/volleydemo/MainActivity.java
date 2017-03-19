package self.edu.volleydemo;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity implements Response.ErrorListener, Response.Listener<String> {

    private TextView data;
    private final static String GOOGLE_INCORRECT_URL = "http://www.google.com1";
    private final static String GOOGLE_URL = "http://www.google.com";

    private static final String TAG = "VolleyDemo";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = (TextView) findViewById(R.id.data);
    }

    public void onClick_CallWebServiceButton(View view) {


        progressDialog = new ProgressDialog(this);
        progressDialog.show();

        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(
//                Request.Method.GET, GOOGLE_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        progressDialog.dismiss();
//                        data.setText(response);
//                        Log.d(TAG, "onResponse() called with: response = [" + response + "]");
//                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        progressDialog.dismiss();
//                        data.setText(error.getMessage());
//                        Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
//                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                    }
//                });
        StringRequest stringRequest = new StringRequest(Request.Method.GET, GOOGLE_URL, this, this);
        queue.add(stringRequest);
        
//        StringRequest stringInCorrectRequest = new StringRequest(Request.Method.GET, GOOGLE_INCORRECT_URL, this, this);
//        queue.add(stringInCorrectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
        progressDialog.dismiss();
        data.setText(error.getMessage());
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "onResponse() called with: response = [" + response + "]");
        progressDialog.dismiss();
        data.setText(response);
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
    }
}

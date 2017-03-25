package self.edu.webservicedemo1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity implements Response.ErrorListener, Response.Listener<String> {

    private final String WEATHER_INFO_URL = "http://api.geonames.org/findNearByWeatherJSON?lat=18.528428&lng=73.842342&radius=80&username=demo";

    private final static String TAG = "weatherdemo";

    private ProgressDialog progressDialog;
    private String temperature;
    private String stationName;
    private String cloudsInformation;
    private int humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //retrieve weather information

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Retrieving Weather Information");
        progressDialog.show();

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, WEATHER_INFO_URL, this, this);
        queue.add(stringRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        Toast.makeText(this, "Failed to retrieve weather information", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
    }

    @Override
    public void onResponse(String response) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        Log.d(TAG, "onResponse() called with: response = [" + response + "]");
        JSONObject jsonResponse;

        try {
            jsonResponse = new JSONObject(response);
            JSONObject weatherObservation = jsonResponse.getJSONObject("weatherObservation");
            temperature = weatherObservation.getString("temperature");
            stationName = weatherObservation.getString("stationName");
            cloudsInformation = weatherObservation.getString("clouds");
            humidity = weatherObservation.getInt("humidity");


            ((TextView) findViewById(R.id.temperature)).setText("Temperature=" + temperature);
            ((TextView) findViewById(R.id.station_name)).setText("Station=" + stationName);
            ((TextView) findViewById(R.id.clouds_information)).setText("Clouds=" + cloudsInformation);
            ((TextView) findViewById(R.id.humidity)).setText("Humidity=" + String.valueOf(humidity));
        } catch (JSONException e) {
            Log.e(TAG, "onResponse: ", e);
        }

        Log.d(TAG, "onResponse: ");
    }
}

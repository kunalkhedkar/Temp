package self.edu.webservicedemo1;

/**
 * Created by imran on 26/3/17.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherInformation {

    @SerializedName("weatherObservation")
    @Expose
    private WeatherObservation weatherObservation;

    public WeatherObservation getWeatherObservation() {
        return weatherObservation;
    }

    public void setWeatherObservation(WeatherObservation weatherObservation) {
        this.weatherObservation = weatherObservation;
    }

}

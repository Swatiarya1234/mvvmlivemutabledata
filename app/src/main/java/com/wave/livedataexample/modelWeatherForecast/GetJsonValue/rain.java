package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 4/18/2018.
 */

public class rain {


    @SerializedName("3h")
    String measurement;

    public String getMeasurement() {
        return measurement;
    }
}

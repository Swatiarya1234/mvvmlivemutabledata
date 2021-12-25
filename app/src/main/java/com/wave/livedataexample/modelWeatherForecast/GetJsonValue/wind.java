package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 4/13/2018.
 */

public class wind {

    @SerializedName("speed")
    private String speeedofwind;

    @SerializedName("deg")
    private String Deg;

    public String getSpeeedofwind() {
        return speeedofwind;
    }
    public String getDeg() {
        return Deg;
    }

}

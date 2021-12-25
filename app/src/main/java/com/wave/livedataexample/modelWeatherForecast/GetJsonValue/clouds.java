package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 4/13/2018.
 */

public class clouds
{


    @SerializedName("all")
    private String all;

    public String getAll() {
        return all;
    }
}

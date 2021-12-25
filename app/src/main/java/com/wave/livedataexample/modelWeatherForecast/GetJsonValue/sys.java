package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 4/13/2018.
 */

public class sys {

    @SerializedName("pod")
    private String pod;

    public String getPod() {
        return pod;
    }

}

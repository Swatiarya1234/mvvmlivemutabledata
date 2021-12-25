package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 4/13/2018.
 */

public class main {

    @SerializedName("temp")
    private String currenttemp;

    @SerializedName("temp_min")
    private String min_temp;

    @SerializedName("temp_max")
    private String max_temp;

    @SerializedName("pressure")
    private String pressure;

    @SerializedName("sea_level")
    private String sea_level;

    @SerializedName("grnd_level")
    private String  ground_level;

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("temp_kf")
    private String tempkf;

    public String getCurrenttemp() {
        return currenttemp;
    }

    public String getMin_temp() {
        return min_temp;
    }

    public String getMax_temp() {
        return max_temp;
    }

    public String getPressure() {
        return pressure;
    }

    public String getSea_level() {
        return sea_level;
    }

    public String getGround_level() {
        return ground_level;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTempkf() {
        return tempkf;
    }

}

package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dell on 4/17/2018.
 */

public class list {

    @SerializedName("dt")
    String dt;

    @SerializedName("dt_txt")
    String date;

    @SerializedName("weather")
    List<weather> weather;

    @SerializedName("main")
    @Expose
    main mainvalue;

    @SerializedName("clouds")
    @Expose
    clouds clouds;

    @Expose
    wind wind;


    @Expose
    sys sys;

    @Expose
    rain rain;


    public rain getRain() {
        return rain;
    }


    public String getDt() {
        return dt;
    }

    public String getDate() {
        return date;
    }

    public List<weather> getWeather() {
        return weather;
    }

    public main getMainvalue() {
        return mainvalue;
    }

    public clouds getClouds() {
        return clouds;
    }

    public wind getWind() {
        return wind;
    }



    public sys getSys() {
        return sys;
    }


}

package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dell on 4/13/2018.
 */

public class object {

    @NonNull
    @SerializedName("cod")
    String cod;

    @SerializedName("message")
    String message;

    @SerializedName("cnt")
    String cnt;

    @SerializedName("list")
    List<list> list;

    @Expose
    city city;

    public city getCity() {
        return city;
    }
    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public String getCnt() {
        return cnt;
    }

    public List<list> getList() {
        return list;
    }
}


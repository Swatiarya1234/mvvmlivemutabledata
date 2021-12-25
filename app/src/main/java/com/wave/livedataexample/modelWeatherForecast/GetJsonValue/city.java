package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 4/17/2018.
 */

public class city {


    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @Expose
    coord coord;

    @SerializedName("country")
    String country;

    @SerializedName("population")
    String population;

    public String getId() {
        return id;
    }

    public String getName() {
            return name;
    }

    public coord getCord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }
}

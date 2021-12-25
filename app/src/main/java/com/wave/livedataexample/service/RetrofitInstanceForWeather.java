package com.wave.livedataexample.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.Api;

public class RetrofitInstanceForWeather {
    private static final String BASE_URL_WEATHER = "http://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;
    public static Api getApiService() {
        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL_WEATHER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(Api.class);

    }
}

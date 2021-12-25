package com.wave.livedataexample.model;

import com.wave.livedataexample.model.BlogWrapper;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.object;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created on : Feb 25, 2019
 * Author     : AndroidWave
 */
public interface RestApiService {


    @GET("feed.json")
    Call<BlogWrapper> getPopularBlog();

}

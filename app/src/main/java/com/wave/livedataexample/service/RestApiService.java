package com.wave.livedataexample.service;

import com.wave.livedataexample.model.BlogWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created on : Feb 25, 2019
 * Author     : AndroidWave
 */
public interface RestApiService {


    @GET("feed.json")
    Call<BlogWrapper> getPopularBlog();

}

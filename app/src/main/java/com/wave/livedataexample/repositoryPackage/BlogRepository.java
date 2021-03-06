package com.wave.livedataexample.repositoryPackage;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.wave.livedataexample.model.Blog;
import com.wave.livedataexample.model.BlogWrapper;
import com.wave.livedataexample.model.RestApiService;
import com.wave.livedataexample.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created on : Feb 26, 2019
 * Author     : AndroidWave
 */
public class BlogRepository {
    private ArrayList<Blog> movies = new ArrayList<>();
    private MutableLiveData<List<Blog>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public BlogRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Blog>> getMutableLiveData() {

       RestApiService  apiService = RetrofitInstance.getApiService();

        Call<BlogWrapper> call = apiService.getPopularBlog();
        // to check the api query that is fired
        Log.d("callvalue",call.request().url().toString());
        call.enqueue(new Callback<BlogWrapper>() {
            @Override
            public void onResponse(Call<BlogWrapper> call, Response<BlogWrapper> response) {
                BlogWrapper mBlogWrapper = response.body();
                if (mBlogWrapper != null && mBlogWrapper.getBlog() != null) {
                    movies = (ArrayList<Blog>) mBlogWrapper.getBlog();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<BlogWrapper> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }
}

package com.wave.livedataexample.repositoryPackage;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.wave.livedataexample.model.Blog;
import com.wave.livedataexample.model.BlogWrapper;
import com.wave.livedataexample.model.RestApiService;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.Api;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.list;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.object;
import com.wave.livedataexample.service.RetrofitInstance;
import com.wave.livedataexample.service.RetrofitInstanceForWeather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private ArrayList<list> list = new ArrayList<>();
    private MutableLiveData<List<list>> mutableLiveData = new MutableLiveData<>();
    private Application application;


    public WeatherRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<list>> getMutableLiveData() {

      Api retrofitInstance = RetrofitInstanceForWeather.getApiService();

        Call<object> call = retrofitInstance.getTasks("Delhi","9ddde7bb16caabbd0f16d18d619f1bee");
        // to check the api query that is fired
        Log.d("callvalueforWeather",call.request().url().toString());
        call.enqueue(new Callback<object>() {
            @Override
            public void onResponse(Call<object> call, Response<object> response) {
                object mObject = response.body();
                if (mObject != null && mObject.getList() != null) {
                    list = (ArrayList<list>) mObject.getList();
                    mutableLiveData.setValue(list);
                }
            }

            @Override
            public void onFailure(Call<object> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }
}

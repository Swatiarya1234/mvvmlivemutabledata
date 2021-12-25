package com.wave.livedataexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.wave.livedataexample.model.Blog;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.list;
import com.wave.livedataexample.repositoryPackage.BlogRepository;
import com.wave.livedataexample.repositoryPackage.WeatherRepository;

import java.util.List;

public class WeatherMainViewModel extends AndroidViewModel {
    public WeatherRepository weatherRepository;
    public WeatherMainViewModel(@NonNull Application application) {
        super(application);
        weatherRepository = new WeatherRepository(application);
    }

    public LiveData<List<list>> getAllWeather() {
        return weatherRepository.getMutableLiveData();
    }
}

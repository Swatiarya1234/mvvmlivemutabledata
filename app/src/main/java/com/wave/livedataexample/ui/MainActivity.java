package com.wave.livedataexample.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wave.livedataexample.R;
import com.wave.livedataexample.model.Blog;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.list;
import com.wave.livedataexample.viewmodel.MainViewModel;
import com.wave.livedataexample.viewmodel.WeatherMainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;
    private WeatherMainViewModel weatherMainViewModel;

    BlogAdapter mBlogAdapter;
    WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationViews();
        weatherMainViewModel = ViewModelProviders.of(this).get(WeatherMainViewModel.class);
        getWeather();
        // lambda expression
        swipeRefresh.setOnRefreshListener(() -> {
          //  getPopularBlog();
            getWeather();
        });
    }

    private void getWeather() {
        swipeRefresh.setRefreshing(true);
        weatherMainViewModel.getAllWeather().observe(this, new Observer<List<list>>() {
            @Override
            public void onChanged(@Nullable List<list> lists) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerViewWeather(lists);
            }
        });
    }

    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
    }

    public void getPopularBlog() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllBlog().observe(this, new Observer<List<Blog>>() {
            @Override
            public void onChanged(@Nullable List<Blog> blogList) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(blogList);
            }
        });
        /**
         * Replace this statement with lambda expression
         * For using set you have to set following lines in app/build.gradle
             // add below line
             compileOptions {
             sourceCompatibility JavaVersion.VERSION_1_8
             targetCompatibility JavaVersion.VERSION_1_8
             }
             // reduce line of code
             mainViewModel.getAllBlog().observe(this, blogList -> prepareRecyclerView(blogList));

         */

    }

    private void prepareRecyclerViewWeather(List<list> list){
        weatherAdapter = new WeatherAdapter(list);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(weatherAdapter);
        weatherAdapter.notifyDataSetChanged();
    }

    private void prepareRecyclerView(List<Blog> blogList) {

        mBlogAdapter = new BlogAdapter(blogList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBlogAdapter);
        mBlogAdapter.notifyDataSetChanged();

    }

}

package com.example.weatherapp.ui.app;

import android.app.Application;

import com.example.weatherapp.data.remote.RetrofitClient;
import com.example.weatherapp.data.remote.WeatherApi;
import com.example.weatherapp.data.repository.WeatherRepository;

public class App extends Application {

    public static WeatherApi api;
    public static WeatherRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient client=new RetrofitClient();
        api= client.provideApi();
        repository=new WeatherRepository();
    }
}

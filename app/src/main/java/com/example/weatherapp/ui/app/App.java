package com.example.weatherapp.ui.app;

import android.app.Application;

import com.example.weatherapp.data.remote.RetrofitClient;
import com.example.weatherapp.data.remote.WeatherApi;
import com.example.weatherapp.data.repository.WeatherRepository;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {

}

package com.example.weatherapp.ui.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.common.Resource;
import com.example.weatherapp.data.models.MainWeather;
import com.example.weatherapp.ui.app.App;

public class WeatherViewModel extends ViewModel {

    public LiveData<Resource<MainWeather>> liveData;

    public WeatherViewModel() {
    }

    public void getWeather(){
        liveData= App.repository.getWeather();
    }
}

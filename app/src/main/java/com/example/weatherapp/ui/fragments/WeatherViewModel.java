package com.example.weatherapp.ui.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.common.Resource;
import com.example.weatherapp.data.models.MainWeather;
import com.example.weatherapp.data.repository.WeatherRepository;
import com.example.weatherapp.ui.app.App;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends ViewModel {
    private WeatherRepository repository;
    public LiveData<Resource<MainWeather>> liveData;
    public LiveData<MainWeather> localLiveData;

    @Inject
    public WeatherViewModel(WeatherRepository repository) {
        this.repository=repository;
    }

    public void getWeather(String cityName){
        liveData=repository.getWeather(cityName);
    }

    public void getAll() {
        localLiveData = repository.getAll();
    }
}
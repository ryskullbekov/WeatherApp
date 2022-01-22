package com.example.weatherapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.common.Resource;
import com.example.weatherapp.data.models.MainWeather;
import com.example.weatherapp.ui.app.App;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    public MutableLiveData<Resource<MainWeather>> getWeather(){
        MutableLiveData<Resource<MainWeather>> liveData= new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        App.api.getWeather("Bishkek","34f284ef687268abb84bca32a3522cf7","metric")
                .enqueue(new Callback<MainWeather>() {
                    @Override
                    public void onResponse(Call<MainWeather> call, Response<MainWeather> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }
                        else{
                            liveData.setValue(Resource.error(null,response.message()));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainWeather> call, Throwable t) {
                        liveData.setValue(Resource.error(null,t.getLocalizedMessage()));
                    }
                });
        return liveData;
    }
}

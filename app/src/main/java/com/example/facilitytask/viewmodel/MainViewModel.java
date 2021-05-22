package com.example.facilitytask.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;

import com.example.facilitytask.AppExecutors;
import com.example.facilitytask.model.FacilityResponse;
import com.example.facilitytask.networking.ApiInterface;
import com.example.facilitytask.networking.RetrofitClient;
import com.example.facilitytask.repository.FacilityRepository;
import com.example.facilitytask.repository.FacilityResponseListener;
import com.google.gson.Gson;


public class MainViewModel extends AndroidViewModel {

    private final FacilityRepository repository;


    public MainViewModel(Application application) {
        super(application);
        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        repository = new FacilityRepository(apiInterface, AppExecutors.getInstance());
    }


    public void getFacilities(FacilityResponseListener listener) {
         repository.getFacilities(listener);
    }
}

package com.example.facilitytask.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.facilitytask.AppExecutors;
import com.example.facilitytask.model.FacilityResponse;
import com.example.facilitytask.networking.ApiInterface;
import com.example.facilitytask.networking.RetrofitClient;
import com.example.facilitytask.repository.FacilityRepository;


public class MainViewModel extends ViewModel {

    private final FacilityRepository repository;

    public MainViewModel(){
        super();
        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        repository = new FacilityRepository(apiInterface, AppExecutors.getInstance());
    }

//    public MainViewModel(Application application) {
//        super(application);
//        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
//        repository = new FacilityRepository(apiInterface, AppExecutors.getInstance());
//    }


    public FacilityResponse getFacilities(){
        return repository.getFacilities();
    }
}

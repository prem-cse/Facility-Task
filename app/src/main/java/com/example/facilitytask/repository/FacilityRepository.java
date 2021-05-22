package com.example.facilitytask.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.facilitytask.AppExecutors;
import com.example.facilitytask.model.FacilityResponse;
import com.example.facilitytask.networking.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacilityRepository {

    /** Tag for logging */
    private static final String TAG = FacilityRepository.class.getSimpleName();

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static FacilityRepository sInstance;
    private final ApiInterface apiInterface;
    private final AppExecutors executors;

    public FacilityRepository(ApiInterface apiInterface,
                              AppExecutors executors) {
        this.apiInterface = apiInterface;
        this.executors = executors;
    }

    public synchronized static FacilityRepository getInstance(
            ApiInterface apiInterface, AppExecutors executors) {
        Log.d(TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(TAG, "Making new repository");
                sInstance = new FacilityRepository(apiInterface, executors);
            }
        }
        return sInstance;
    }

    /**
     * Make a network request by calling enqueue and provide a object of FacilityResponse for ViewModel
     */
    public void getFacilities(FacilityResponseListener listener) {

        Call<FacilityResponse> call = apiInterface.getFacilities();
        call.enqueue(new Callback<FacilityResponse>() {
            @Override
            public void onResponse(Call<FacilityResponse> call, Response<FacilityResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<FacilityResponse> call, Throwable t) {
               listener.onFailure(t);
            }
        });
    }
}

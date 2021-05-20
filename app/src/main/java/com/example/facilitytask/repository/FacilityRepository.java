package com.example.facilitytask.repository;

import android.util.Log;

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
    public FacilityResponse getFacilities() {
        final FacilityResponse[] facilityResponse = {new FacilityResponse()};
        apiInterface.getFacilities()
                // Calls are executed with asynchronously with enqueue and notify callback of its response
                .enqueue(new Callback<FacilityResponse>() {
                    @Override
                    public void onResponse(Call<FacilityResponse> call, Response<FacilityResponse> response) {
                        if (response.isSuccessful()) {
                             facilityResponse[0] = response.body();
                        }
                    }

                    @Override
                    public void onFailure(Call<FacilityResponse> call, Throwable t) {
                        Log.e(TAG, "Failed getting response: " + t.getMessage());
                    }
                });
        return facilityResponse[0];
    }
}

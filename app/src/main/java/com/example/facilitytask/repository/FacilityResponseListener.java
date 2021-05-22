package com.example.facilitytask.repository;

import com.example.facilitytask.model.FacilityResponse;

public interface FacilityResponseListener {

    void onSuccess(FacilityResponse response);
    void onFailure(Throwable t);
}

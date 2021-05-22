package com.example.facilitytask.networking;

import com.example.facilitytask.model.FacilityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * The facility database api interface. Retrofit turns HTTP API into a Java interface.
 */
public interface ApiInterface {

    String contentType = "Content-Type: application/json";

    @Headers(contentType)
    @GET("/ricky1550/pariksha/db")
    Call<FacilityResponse> getFacilities();
}

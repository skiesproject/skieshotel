package com.example.skieshotel.rest;

import com.example.skieshotel.model.RootHotelModel;
import com.example.skieshotel.model.HotelItem;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("purwakarta/hotel") //endpoint
    Call<RootHotelModel> getData();
}

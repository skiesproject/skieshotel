package com.example.skieshotel.model;

import java.util.ArrayList;

import com.example.skieshotel.model.HotelItem;
import com.google.gson.annotations.SerializedName;

public class RootHotelModel{

    @SerializedName("hotel")
    private ArrayList<HotelItem> hotel;

    public void setHotel(ArrayList<HotelItem> hotel){
        this.hotel = hotel;
    }

    public ArrayList<HotelItem> getHotel(){
        return hotel;
    }
}
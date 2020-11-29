package com.example.skieshotel;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skieshotel.model.HotelItem;
import com.example.skieshotel.model.RootHotelModel;
import com.example.skieshotel.rest.ApiConfig;
import com.example.skieshotel.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<HotelItem> hotelItems;
    private HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        hotelItems = new ArrayList<>();
        getData();

    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<RootHotelModel>() {
            @Override
            public void onResponse(Call<RootHotelModel> call, Response<RootHotelModel> response) {
                if (response.isSuccessful()) {
                    hotelItems = response.body().getHotel();
                    hotelAdapter = new HotelAdapter(hotelItems, getApplicationContext());
                    recyclerView.setAdapter(hotelAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<RootHotelModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.Recycler_View);
    }
}

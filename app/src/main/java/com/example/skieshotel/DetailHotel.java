package com.example.skieshotel;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.detail_hotel);

        TextView mNamaText = findViewById(R.id.hotelNama);
        TextView mAlamatText = findViewById(R.id.hotelAlamat);
        TextView mNo_telp = findViewById(R.id.no_telp);
        ImageView mHotelImage = findViewById(R.id.hotelImage);

        mNamaText.setText("Nama Hotel : " + getIntent().getStringExtra("nama"));
        mAlamatText.setText("Alamat Hotel : " + getIntent().getStringExtra( "alamat"));
        mNo_telp.setText("No. Telepon : " + getIntent().getStringExtra( "nomor_telp"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambar_url")).error(R.mipmap.ic_launcher).override(512, 512).into(mHotelImage);
    }
}

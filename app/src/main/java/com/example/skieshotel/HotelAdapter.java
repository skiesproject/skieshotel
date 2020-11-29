package com.example.skieshotel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.skieshotel.model.HotelItem;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private ArrayList<HotelItem> mHotelData;
    private Context mContext;

    public HotelAdapter(ArrayList<HotelItem> mHotelData, Context mContext) {
        this.mHotelData = mHotelData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_hotel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mNamaText.setText(mHotelData.get(position).getNama());
        Glide.with(mContext).load(mHotelData.get(position).getGambarUrl()).error(R.mipmap.ic_launcher).override(512, 512).into(holder.mHotelImage);
        holder.cardClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailHotel.class);
                intent.putExtra("nama", mHotelData.get(position).getNama());
                intent.putExtra("alamat", mHotelData.get(position).getAlamat());
                intent.putExtra("nomor_telp", mHotelData.get(position).getNomorTelp());
                intent.putExtra("gambar_url", mHotelData.get(position).getGambarUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHotelData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mNamaText;
        private TextView mAlamatText;
        private TextView mNo_telp;
        private ImageView mHotelImage;
        private CardView cardClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mNamaText = itemView.findViewById(R.id.hotelNama);
            mAlamatText = itemView.findViewById(R.id.hotelAlamat);
            mNo_telp = itemView.findViewById(R.id.no_telp);
            mHotelImage = itemView.findViewById(R.id.hotelImage);
            cardClick = itemView.findViewById(R.id.card_view);
        }
    }
}

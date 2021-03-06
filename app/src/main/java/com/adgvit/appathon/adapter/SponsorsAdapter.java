package com.adgvit.appathon.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adgvit.appathon.R;
import com.adgvit.appathon.model.SponsorsModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.MyViewHolder> {
    List<SponsorsModel> sponsorList;
    Context mContext;

    public SponsorsAdapter(List<SponsorsModel> sponsorList, Context mContext) {
        this.sponsorList = sponsorList;
        this.mContext = mContext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView sponsorImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sponsorImage = itemView.findViewById(R.id.sponsorImage);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.sponsorsrecycleritem,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SponsorsModel model = sponsorList.get(position);
        Glide.with(mContext).load(model.getImage()).into(holder.sponsorImage);
        holder.sponsorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = sponsorList.get(position).getWebsite();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item));
                mContext.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sponsorList.size();
    }


}

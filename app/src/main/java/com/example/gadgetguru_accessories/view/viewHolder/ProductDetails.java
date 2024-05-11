package com.example.gadgetguru_accessories.view.viewHolder;

import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.gadgetguru_accessories.R;



public class ProductDetails extends RecyclerView.ViewHolder  {


    public TextView textViewName;
    public TextView textViewPrice;

    public ImageView imgView;

    public ProductDetails(@NonNull View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.textViewName);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        imgView = itemView.findViewById(R.id.imageView);


    }



}
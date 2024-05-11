package com.example.gadgetguru_accessories.view.viewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadgetguru_accessories.R;

public class HomeProduct extends RecyclerView.ViewHolder {
    public TextView textViewName;
    public TextView textViewPrice;
    public ImageView imageView;

    public HomeProduct(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        imageView = itemView.findViewById(R.id.imageView);
    }


//    public HomeProduct() {
//        super(this);
//    }
}

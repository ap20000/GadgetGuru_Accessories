package com.example.gadgetguru_accessories.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadgetguru_accessories.R;
import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.view.viewHolder.ProductDetails;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<ProductDetails> {

    private ArrayList<Product> products;

    public PostAdapter() {
        this.products = new ArrayList<>();
    }



    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    @NonNull
    @Override
    public ProductDetails onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_product, parent, false);
        return new ProductDetails(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductDetails holder, int position) {
        Product product = products.get(position);
        holder.textViewName.setText(product.getProductName());
        holder.textViewPrice.setText(product.getProductPrice());

        int placeholderResource = R.drawable.
                ic_launcher_background;
        int errorResource = R.drawable.ic_launcher_foreground;

        Picasso.get()
                .load(product.getImage())
                .placeholder(placeholderResource)
                .error(errorResource)
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
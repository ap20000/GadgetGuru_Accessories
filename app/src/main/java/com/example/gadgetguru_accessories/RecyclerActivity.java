package com.example.gadgetguru_accessories;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.utilities.ApiClient;
import com.example.gadgetguru_accessories.view.adapter.PostAdapter;

import java.util.ArrayList;


public class RecyclerActivity extends AppCompatActivity {


    private PostAdapter adapter;
    ArrayList<Product> users= new ArrayList<Product>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productrecycler);

        RecyclerView recyclerView = findViewById(R.id.rvPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter();
        recyclerView.setAdapter(adapter);

        ApiClient apiClient = new ApiClient();
        apiClient.getProducts(adapter);
    }

}

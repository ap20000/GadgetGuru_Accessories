package com.example.gadgetguru_accessories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gadgetguru_accessories.utilities.ApiClient;
import com.example.gadgetguru_accessories.view.adapter.PostAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product);



        PostAdapter adapter = new PostAdapter();


        ApiClient apiClient = new ApiClient();
        apiClient.getProducts(adapter);
    }
}
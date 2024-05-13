package com.example.gadgetguru_accessories.view.viewHolder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.utilities.ApiCallback;
import com.example.gadgetguru_accessories.utilities.ApiClient;
import com.example.gadgetguru_accessories.view.adapter.HomePostAdapter;
import com.example.gadgetguru_accessories.R;

import java.util.ArrayList;

public class HomeScreen extends Fragment {

    private RecyclerView recyclerView;
    private HomePostAdapter adapter;
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        recyclerView = view.findViewById(R.id.rvPost);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomePostAdapter(products);
        recyclerView.setAdapter(adapter);

        // Fetch data and update the adapter
        ApiClient apiClient = new ApiClient();
        apiClient.getAccessories(new ApiCallback() {
            @Override
            public void Success(ArrayList<Product> productList) {
                products.clear();
                products.addAll(productList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void Failure(String message) {
                // Handle failure
            }
        });

        return view;
    }
}


package com.example.gadgetguru_accessories.view.viewHolder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadgetguru_accessories.R;
import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.utilities.ApiCallback;
import com.example.gadgetguru_accessories.utilities.ApiClient;
import com.example.gadgetguru_accessories.view.adapter.AdapterPost;

import java.util.ArrayList;

public class ProductFragment extends Fragment {

    private RecyclerView recyclerViewAccessories;
    private AdapterPost adapter;
    private ArrayList<Product> products = new ArrayList<>();

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_activity, container, false);

        recyclerViewAccessories = view.findViewById(R.id.rvPosts);
        recyclerViewAccessories.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterPost(products);
        recyclerViewAccessories.setAdapter(adapter);

        // Fetch products from API
        ApiClient apiClient = new ApiClient();
        apiClient.getAccessories(new ApiCallback() {
            @Override
            public void Success(ArrayList<Product> accessoriesList) {
                products.clear();
                products.addAll(accessoriesList);
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

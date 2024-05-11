package com.example.gadgetguru_accessories;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.utilities.ApiCallback;
import com.example.gadgetguru_accessories.utilities.ApiClient;
import com.example.gadgetguru_accessories.view.adapter.HomePostAdapter;
import com.example.gadgetguru_accessories.view.viewHolder.Contact;
import com.example.gadgetguru_accessories.view.viewHolder.HomeScreen;
import com.example.gadgetguru_accessories.view.viewHolder.ProductDetails;
import com.example.gadgetguru_accessories.view.viewHolder.ProductFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    HomeScreen homeFragment = new HomeScreen();
//    ProfileFragment profileFragment = new ProfileFragment();
    ProductFragment productFragment = new ProductFragment();
//    HobbiesFragment hobbiesFragment = new HobbiesFragment();
    Contact contactFragment = new Contact();
    private HomePostAdapter adapter;
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home_screen);
        setContentView(R.layout.activity_main);
//        RecyclerView recyclerView = findViewById(R.id.rvPost);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new HomePostAdapter(products);
//        recyclerView.setAdapter(adapter);
//
//        ApiClient apiClient = new ApiClient();
//        apiClient.getProducts(new ApiCallback() {
//            @Override
//            public void onSuccess(ArrayList<Product> productList) {
//                products.clear();
//                products.addAll(productList);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(String message) {
//                // Handle failure
//            }
//        });
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
//
//        }else if(item.getItemId() == R.id.profile){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
//            return true;
        }else if(item.getItemId() == R.id.product){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, productFragment).commit();
            return true;
//        }else if(item.getItemId() == R.id.hobbies){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, hobbiesFragment).commit();
//            return true;
        }else if(item.getItemId() == R.id.contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
            return true;
        } else {
            return false;
        }
    }
}
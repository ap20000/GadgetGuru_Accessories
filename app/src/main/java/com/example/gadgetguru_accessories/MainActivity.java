package com.example.gadgetguru_accessories;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gadgetguru_accessories.model.Contact;
import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.view.adapter.HomePostAdapter;
import com.example.gadgetguru_accessories.view.viewHolder.ContactFragment;
import com.example.gadgetguru_accessories.view.viewHolder.HomeScreen;
import com.example.gadgetguru_accessories.view.viewHolder.ProductFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView NavigationView;
    HomeScreen homeFragment = new HomeScreen();
    ProfileFragment profileFragment = new ProfileFragment();
    ProductFragment productFragment = new ProductFragment();
//    HobbiesFragment hobbiesFragment = new HobbiesFragment();
    ContactFragment contactFragment = new ContactFragment();
    private HomePostAdapter adapter;
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        NavigationView = findViewById(R.id.NavigationView);
        NavigationView.setOnItemSelectedListener(this);
        NavigationView.setSelectedItemId(R.id.home);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
//
        }else if(item.getItemId() == R.id.profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
            return true;
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
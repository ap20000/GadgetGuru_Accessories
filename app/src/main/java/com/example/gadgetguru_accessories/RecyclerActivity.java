//package com.example.gadgetguru_accessories;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.gadgetguru_accessories.model.Product;
//import com.example.gadgetguru_accessories.utilities.ApiCallback;
//import com.example.gadgetguru_accessories.utilities.ApiClient;
//import com.example.gadgetguru_accessories.view.adapter.PostAdapter;
//
//import java.util.ArrayList;
//
//public class RecyclerActivity extends AppCompatActivity {
//
//    private PostAdapter adapter;
//    private ArrayList<Product> products = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.recycler_activity);
//
//        RecyclerView recyclerView = findViewById(R.id.rvPosts);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new PostAdapter(products);
//        recyclerView.setAdapter(adapter);
//
//        ApiClient apiClient = new ApiClient();
//        apiClient.getAccessories(new ApiCallback() {
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
//    }
//}

package com.example.gadgetguru_accessories.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gadgetguru_accessories.model.LoginUser;
import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.model.User;

import com.example.gadgetguru_accessories.view.adapter.PostAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://192.168.1.110/api/";

//    private static final String BASE_URL = "http://100.64.215.72/api/";
//    private static final String BASE_URL = "http://100.64.201.80/api/";

    private static Retrofit retrofit;

    // Create the Retrofit instance
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public ApiService apiService = retrofit.create(ApiService.class);

    private ArrayList<Product> products = new ArrayList<>();

    // Create ApiService instance
    public static ApiService createApiService() {
        return retrofit.create(ApiService.class);
    }

    // Method to register a user
    public static void registerUser(User user, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();

        // Call the registerUser method in ApiService and pass the user object
        apiService.registerUser(user).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    // Registration successful
                    Log.d("ApiClient", "User registration successful");
                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show();
                    // Optionally, you can navigate to another activity upon successful registration
                    // startActivity(new Intent(context, MainActivity.class));
                } else {
                    // Registration failed
                    Log.d("ApiClient", "Failed to register user. Response code: " + response.code());
                    Toast.makeText(context, "Failed to register user. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Registration failed due to network error or other issues
                Log.e("ApiClient", "Registration failed: " + t.getMessage());
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to register user. Error: " + t.getMessage();
                }
                // Display error message to the user
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }



    public static void loginUser(String username, String password, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();

        // Call the loginUser method in ApiService and pass the username and password as query parameters

        LoginUser user = new LoginUser(username, password);
        apiService.loginUser(user).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.code());
                    // Show a successful login message
                    Toast.makeText(context, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "User login successful");
                } else {
                    // Show an error message based on the response code
                    if (response.code() == 401) { // Unauthorized - Incorrect username or password
                        Toast.makeText(context, "Incorrect username or password. Please try again.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to login user. Please try again later.", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("ApiClient", "Failed to login user. Response code: " + response.code());
                }
            }


            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Login failed due to network error or other issues
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to login user. Error: " + t.getMessage();
                }
                // Display error message to the user
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
                Log.e("ApiClient", "Login failed: " + errorMessage);
            }
        });
    }

//    public static void getProducts(Context context) {
//        // Get the ApiService instance
//        ApiService apiService = createApiService();
//
//        // Call the getProducts method in ApiService
//        apiService.getProducts().enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                if (response.isSuccessful()) {
//                    List<Product> products = response.body();
//                    // Display products in RecyclerView
//                    // Assuming you have a method to set up RecyclerView and adapter
//                    // For example, you can create a method in your activity or fragment
//                    // and call it from here passing the products list
//                    // setupRecyclerView(products);
//                } else {
//                    // Handle error
//                    Log.d("ApiClient", "Failed to get products. Response code: " + response.code());
//                    Toast.makeText(context, "Failed to get products. Please try again later.", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                // Handle network failure
//                String errorMessage;
//                if (t instanceof IOException) {
//                    errorMessage = "Network error. Please check your internet connection.";
//                } else {
//                    errorMessage = "Failed to get products. Error: " + t.getMessage();
//                }
//                // Display error message to the user
//                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
//                Log.e("ApiClient", "Failed to get products: " + errorMessage);
//            }
//        });
//    }

    public void getProducts(ApiCallback callback) {
        Call<List<Product>> call = createApiService().getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Product> products = new ArrayList<>(response.body());
                    callback.onSuccess(products);
                } else {
                    callback.onFailure("Failed to get products. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                callback.onFailure("Failed to get products: " + t.getMessage());
            }
        });
    }



}

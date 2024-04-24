package com.example.gadgetguru_accessories.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.gadgetguru_accessories.model.User;
import com.example.gadgetguru_accessories.model.loginUser;

import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://192.168.1.142/api/";
    private static Retrofit retrofit;

    // Create the Retrofit instance
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Create ApiService instance
    public static ApiService createApiService() {
        return retrofit.create(ApiService.class);
    }

    // Method to register a user
    public static void registerUser(User user, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();


        // Call the registerUser method in ApiService and pass the user object
        apiService.registerUser(user).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) {

                if (response.isSuccessful()) {
                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "User registration successful");
                    // Optionally, you can navigate to another activity upon successful registration
                    // startActivity(new Intent(context, MainActivity.class));
                } else {
                    // Display error message to the user
                    Toast.makeText(context, "Failed to register user. Please try again later.", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "Failed to register user. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("issue", t.getMessage());
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to register user. Error: " + t.getMessage();
                }
                // Display error message to the user
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
                Log.e("ApiClient", "Registration failed: " + errorMessage);
            }
        });
    }


    public static void loginUser(loginUser user, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();

        // Call the loginUser method in ApiService and pass the user object
        apiService.loginUser(user).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "User registration successful");
                    // Optionally, you can navigate to another activity upon successful registration
                    // startActivity(new Intent(context, MainActivity.class));
                } else {
                    // Display error message to the user
                    Toast.makeText(context, "Failed to login user. Please try again later.", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "Failed to  user. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                // Login failed due to network error or other issues
                Toast.makeText(context, "Failed to login. Please try again later.", Toast.LENGTH_SHORT).show();
                Log.e("LoginPage", "Login failed: " + t.getMessage());
            }
        });
    }


}

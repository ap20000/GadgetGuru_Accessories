package com.example.gadgetguru_accessories.view.viewHolder;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gadgetguru_accessories.R;
import com.example.gadgetguru_accessories.model.User;
import com.example.gadgetguru_accessories.utilities.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPage extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        userNameEditText = findViewById(R.id.loginUsername);
        passwordEditText = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/api/loginGet.php/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        apiService = retrofit.create(ApiService.class);

        loginButton.setOnClickListener(v -> {
            String username = userNameEditText.getText().toString().trim().toLowerCase();
            String password = passwordEditText.getText().toString();

            // Make network request to API
            Call<User> call = apiService.getlogin(username, password);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        User user = response.body();
                        Log.d("Login", "User found: " + new Gson().toJson(user));
                        // Perform login using user credentials
                    } else {
                        Log.d("Login", "User not found");
                        // Handle case where user is not found
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("Login", "Error: " + t.getMessage());
                    // Handle failure
                }
            });
        });
    }
}

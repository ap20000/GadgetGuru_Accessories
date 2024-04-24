package com.example.gadgetguru_accessories.view.viewHolder;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gadgetguru_accessories.R;
import com.example.gadgetguru_accessories.model.User;
import com.example.gadgetguru_accessories.utilities.ApiClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity {
    private EditText fullNameEditText;
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        fullNameEditText = findViewById(R.id.signupFullName);
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(v -> {
            String fullName = fullNameEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Inside registerButton.setOnClickListener
            Log.d("RegisterPage", "Full Name: " + fullName);
            Log.d("RegisterPage", "Username: " + username);
            Log.d("RegisterPage", "Email: " + email);
            Log.d("RegisterPage", "Password: " + password);

            if (fullName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegisterPage.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                User user = new User(fullName, username, email, password);
                System.out.println(user.getFullName());
                registerUser(user);
            }
        });
    }

    private void registerUser(User user) {
        ApiClient.registerUser(user, this);
    }
}

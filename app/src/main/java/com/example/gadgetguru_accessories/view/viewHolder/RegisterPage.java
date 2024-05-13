package com.example.gadgetguru_accessories.view.viewHolder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        TextView signupText = findViewById(R.id.signupText);
        signupText.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterPage.this, LoginPage.class);
            startActivity(intent);
            finish(); // Optional, to close the current activity
        });
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
            } else if (!isValidFullName(fullName)) {
                Toast.makeText(RegisterPage.this, "Full Name cannot contain symbols", Toast.LENGTH_SHORT).show();
            } else if (!isValidUsername(username)) {
                Toast.makeText(RegisterPage.this, "Username cannot contain symbols", Toast.LENGTH_SHORT).show();
            } else if (!isValidFull(fullName)) {
                Toast.makeText(RegisterPage.this, "Full Name cannot contain number", Toast.LENGTH_SHORT).show();
            } else {
                User accessoriesuser = new User(fullName, username, email, password);
                System.out.println(accessoriesuser.getFullName());
                UsereaddRegister(accessoriesuser);
            }
        });
    }

    private void UsereaddRegister(User accessoriesuser) {
        ApiClient.UsereaddRegister(accessoriesuser, this);
    }
    private boolean isValidFullName(String fullName) {
        // Regular expression to check if full name contains only letters, spaces, and hyphens
        String regex = "^[a-zA-Z\\s-]*$";
        return fullName.matches(regex);
    }

    private boolean isValidUsername(String username) {
        // Regular expression to check if username contains only letters, digits, and underscores
        String regex = "^[a-zA-Z0-9_]*$";
        return username.matches(regex);
    }
    private boolean isValidFull(String fullName) {
        // Regular expression to check if full name contains only letters, spaces, and hyphens, and is not empty
        String regex = "^[a-zA-Z\\s-]+$";
        return fullName.matches(regex);
    }

}

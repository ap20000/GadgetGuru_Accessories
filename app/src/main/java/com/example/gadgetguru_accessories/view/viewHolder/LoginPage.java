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
import com.example.gadgetguru_accessories.utilities.ApiCallback;
import com.example.gadgetguru_accessories.utilities.ApiClient;

import com.example.gadgetguru_accessories.MainActivity;
import com.example.gadgetguru_accessories.utilities.LoginApiCalBack;
// Corrected interface name

public class LoginPage extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        usernameEditText = findViewById(R.id.loginUsername);
        passwordEditText = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        TextView signupText = findViewById(R.id.signupText);
        signupText.setOnClickListener(v -> {
            Intent intent = new Intent(LoginPage.this, RegisterPage.class);
            startActivity(intent);
            finish(); // Optional, to close the current activity
        });
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            Log.d("LoginPage", "Username: " + username);
            Log.d("LoginPage", "Password: " + password);

            // Validate input fields
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginPage.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            }else if (!isValidUsername(username)) {
                Toast.makeText(LoginPage.this, "Username cannot contain symbols", Toast.LENGTH_SHORT).show();
            } else {
                // Call loginUser method with username, password, and context
                ApiClient.loginUser(username, password, LoginPage.this);
            }
        });

    }
    private boolean isValidUsername(String username) {
        // Regular expression to check if username contains only letters, digits, and underscores
        String regex = "^[a-zA-Z0-9_]*$";
        return username.matches(regex);
    }
}
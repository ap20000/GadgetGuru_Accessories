package com.example.gadgetguru_accessories.view.viewHolder;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gadgetguru_accessories.R;

import com.example.gadgetguru_accessories.model.User;
import com.example.gadgetguru_accessories.model.loginUser;
import com.example.gadgetguru_accessories.utilities.ApiClient;

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

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            Log.d("LoginPage", "Username: " + username);
            Log.d("LoginPage", "Password: " + password);

            // Validate input fields
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginPage.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            } else {
                // Call loginUser method with username, password, and context
                loginUser user = new loginUser( username,  password);
                ApiClient.loginUser(user, LoginPage.this);
            }
        });
    }

    private void loginUser(loginUser user) {
        ApiClient.loginUser(user, this);
    }

}

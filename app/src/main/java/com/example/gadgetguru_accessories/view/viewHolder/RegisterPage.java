//package com.example.gadgetguru_accessories.view.viewHolder;
//
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.gadgetguru_accessories.R;
//import com.example.gadgetguru_accessories.controller.GadgetDatabase;
//import com.example.gadgetguru_accessories.model.User;
//import com.example.gadgetguru_accessories.view.viewHolder.LoginPage;
//
//public class RegisterPage extends AppCompatActivity {
//    private static final String TAG = "RegisterPage";
//    private EditText fullNameEditText;
//    private EditText usernameEditText;
//    private EditText emailEditText;
//    private EditText passwordEditText;
//    private Button registerButton;
//    private GadgetDatabase gadgetDatabase;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.register_page);
//
//        fullNameEditText = findViewById(R.id.signupFullName);
//        usernameEditText = findViewById(R.id.username);
//        emailEditText = findViewById(R.id.email);
//        passwordEditText = findViewById(R.id.password);
//        registerButton = findViewById(R.id.registerButton);
//
//        gadgetDatabase = GadgetDatabase.getInstance(this);
//
//        registerButton.setOnClickListener(v -> {
//            String fullName = fullNameEditText.getText().toString();
//            String username = usernameEditText.getText().toString();
//            String email = emailEditText.getText().toString();
//            String password = passwordEditText.getText().toString();
//
//            if (fullName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
//                Toast.makeText(RegisterPage.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
//                return;
//            } else {
//
//            }
//
//            new InsertUserTask().execute(fullName, username, email, password);
//        });
//    }
//
//    private class InsertUserTask extends AsyncTask<String, Void, Boolean> {
//        @Override
//        protected Boolean doInBackground(String... params) {
//            String fullName = params[0];
//            String username = params[1];
//            String email = params[2];
//            String password = params[3];
//
//            // Check if username already exists
//            if (gadgetDatabase.userDao().getUserByUsername(username) != null) {
//                return false;
//            }
//
//            // Insert user into database
////            User user = new User(int id, String fullName, String userName, String email, String password);
//            user.setFullName(fullName);
//            user.setUserName(username);
//            user.setEmail(email);
//            user.setPassword(password);
//
//            try {
//                gadgetDatabase.userDao().insert(user);
//                Log.d(TAG, "User inserted successfully: " + user.toString());
//                return true;
//            } catch (Exception e) {
//                Log.e(TAG, "Error inserting user: " + e.getMessage());
//                return false;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(Boolean result) {
//            if (result) {
//                Toast.makeText(RegisterPage.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(RegisterPage.this, LoginPage.class));
//                finish();
//            } else {
//                Toast.makeText(RegisterPage.this, "Username already exists", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}

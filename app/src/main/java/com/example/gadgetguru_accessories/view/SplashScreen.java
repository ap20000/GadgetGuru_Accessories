package com.example.gadgetguru_accessories.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gadgetguru_accessories.MainActivity;
import com.example.gadgetguru_accessories.R;
import com.example.gadgetguru_accessories.view.viewHolder.LoginPage;
import com.example.gadgetguru_accessories.view.viewHolder.RegisterPage;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 300;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, LoginPage.class);
                startActivity(intent);


                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}


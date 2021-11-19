package com.example.blooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getSupportActionBar().hide();
        takeToMainPage();
    }

    private void takeToMainPage() {
        int secondsDelayed = 3;
        new Handler().postDelayed(() -> {
            startActivity(
                    new Intent(
                            SplashActivity.this , MainActivity.class
                    )
            );
            finish();
        }, secondsDelayed * 1000);
    }

}

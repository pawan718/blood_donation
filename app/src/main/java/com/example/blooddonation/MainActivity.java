package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loginpage(View view){
            Intent intent = new Intent(this, firstpage.class);
        startActivity(intent);
    }



    public void signuppage(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}
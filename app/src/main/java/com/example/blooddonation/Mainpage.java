package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.example.blooddonation.databinding.ActivityMainpageBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Mainpage extends AppCompatActivity {
    ActivityMainpageBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        binding = ActivityMainpageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.seting:
                break;
            case R.id.logout:
                auth.signOut();
                Intent intent = new Intent(Mainpage.this, MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;


    }
    public void needblood(View view){
        Intent intent2 = new Intent(this , NeedBlood.class);
        startActivity(intent2);
    }
    public void needocygen(View view){
        Intent intent3 = new Intent(this,NeedOxygen.class);
        startActivity(intent3);
    }
    public void maps(View view){
        Intent intent4 = new Intent(this, usersdata.class);
        startActivity(intent4);
    }
}
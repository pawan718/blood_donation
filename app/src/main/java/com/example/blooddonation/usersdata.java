package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.blooddonation.attributes.users_data_adaptar;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class usersdata extends AppCompatActivity {
    RecyclerView view;
    users_data_adaptar users_data_adaptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersdata);


        view =  (RecyclerView) findViewById(R.id.rv);
        view.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Mainmodel> options =
                new FirebaseRecyclerOptions.Builder<Mainmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users2"), Mainmodel.class)
                        .build();
        users_data_adaptar = new users_data_adaptar(options);
        view.setAdapter(users_data_adaptar);
    }

    public usersdata() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        users_data_adaptar.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        users_data_adaptar.startListening();
    }
}
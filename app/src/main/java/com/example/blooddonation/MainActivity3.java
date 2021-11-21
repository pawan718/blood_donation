package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.blooddonation.attributes.Users;
import com.example.blooddonation.databinding.ActivityMain3Binding;
import com.example.blooddonation.databinding.ActivityMain3Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity3 extends AppCompatActivity {


    ActivityMain3Binding binding;

    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        auth = FirebaseAuth.getInstance();
//        progressDialog = new ProgressDialog(MainActivity2.this);
//        progressDialog.setTitle("Signup");
//        progressDialog.setMessage("signup to your account");


        database = FirebaseDatabase.getInstance();

        binding.register.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    auth.createUserWithEmailAndPassword(binding.editTextTextEmailAddress.getText().toString(), binding.editTextTextPassword2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                                            if (task.isSuccessful()) {
                                                                Users users = new Users(binding.editTextTextPersonName.getText().toString(), binding.editTextTextEmailAddress.getText().toString(), binding.editTextPhone2.getText().toString(),
                                                                        binding.editTextTextPassword2.getText().toString(), binding.editTextTextPostalAddress.getText().toString(), binding.editTextTextPersonName3.getText().toString(), binding.editTextTextPersonName4.getText().toString());

                                                                String id = task.getResult().getUser().getUid();
                                                                database.getReference().child("users").child(id).setValue(users);
                                                                Toast.makeText(MainActivity3.this, "user registered successfuly", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                Toast.makeText(MainActivity3.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                                }
                                            }
        );

    }

    public void login(View view) {
        Intent intent = new Intent(this, firstpage.class);
        startActivity(intent);
    }
}
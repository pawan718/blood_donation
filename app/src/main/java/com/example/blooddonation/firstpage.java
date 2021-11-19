package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import com.example.blooddonation.databinding.ActivityFirstpageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class firstpage extends AppCompatActivity {
    ActivityFirstpageBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(firstpage.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("login to your account");


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!binding.Email.getText().toString() && !binding.editTextTextPassword.getText().toString()) {
//                if(binding.Email.getText().toString()!= null && binding.editTextTextPassword.getText().toString()!=null) {
//                    Toast.makeText(firstpage.this, "logged in", Toast.LENGTH_SHORT).show();


                    progressDialog.show();
                    auth.signInWithEmailAndPassword(binding.Email.getText().toString(), binding.editTextTextPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(firstpage.this, Mainpage.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(firstpage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
//                }else{
//                    Toast.makeText(firstpage.this, "please enter values", Toast.LENGTH_SHORT).show();
//                }




            }
        });



//        if(auth.getCurrentUser() != null){
//            Intent intent = new Intent(firstpage.this, Mainpage.class);
//            startActivity(intent);
//        }

    }







    public void mainpage(View view) {
    Intent intent = new Intent(this, Mainpage.class);
    startActivity(intent);
}
        public void create(View view){
            Intent intent1 = new Intent(this,MainActivity3.class);
            startActivity(intent1);
    }

}
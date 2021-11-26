package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blooddonation.attributes.Users2;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

public class NeedBlood extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_blood);
        firebaseDatabase = FirebaseDatabase.getInstance();

        FirebaseMessaging.getInstance().subscribeToTopic("all");

        EditText phoneno = findViewById(R.id.ContactNumber);
        EditText email = findViewById(R.id.Email);
        EditText name = findViewById(R.id.name);
        TextInputLayout bloodMenu = findViewById(R.id.bloodMenu);
        EditText message = findViewById(R.id.message);
        Button request = findViewById(R.id.requestBloodButton);

        String arr[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getBaseContext(), R.layout.textview_drop_down, arr);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) bloodMenu.getEditText();
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setAdapter(arrayAdapter);
        }
        EditText blood = bloodMenu.getEditText();
        request.setOnClickListener(v -> {

            if (!blood.getText().toString().isEmpty() && !message.getText().toString().isEmpty()) {
                firebaseDatabase = FirebaseDatabase.getInstance();

                reference = firebaseDatabase.getReference("users2");
                Users2 users2 = new Users2(name.getText().toString(), blood.getText().toString(), phoneno.getText().toString(), email.getText().toString(), message.getText().toString());
                reference.child(users2.getphoneno()).setValue(users2);


                FcmNotificationsSender sender = new FcmNotificationsSender("/topics/all", blood.getText().toString(),
                        message.getText().toString(), getApplicationContext(), NeedBlood.this);

                sender.SendNotifications();
                Intent intent = new Intent(NeedBlood.this, Thank_you.class);
                startActivity(intent);
            } else {
                Toast.makeText(NeedBlood.this, "Please enter details", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
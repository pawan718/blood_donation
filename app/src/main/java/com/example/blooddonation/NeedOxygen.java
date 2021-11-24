package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkDispatcher;
import com.google.firebase.messaging.FirebaseMessaging;

public class NeedOxygen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_oxygen);
        FirebaseMessaging.getInstance().subscribeToTopic("all");
        EditText message2 = findViewById(R.id.message);
        Button request2 = findViewById(R.id.request2);
        String oxygen = "O";

        request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!oxygen.toString().isEmpty() && !message2.getText().toString().isEmpty()){
                    FcmNotificationsSender sender = new FcmNotificationsSender("/topics/all",oxygen.toString(),
                            message2.getText().toString(), getApplicationContext(),NeedOxygen.this);

                    sender.SendNotifications();
                    Intent intent = new Intent(NeedOxygen.this, Thank_you.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(NeedOxygen.this, "please enter your details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
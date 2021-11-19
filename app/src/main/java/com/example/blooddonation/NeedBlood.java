package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class NeedBlood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_blood);
        FirebaseMessaging.getInstance().subscribeToTopic("all");

        EditText blood = findViewById(R.id.editbloodgroup);
        EditText message = findViewById(R.id.editmessage);
        Button request = findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!blood.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){
                    FcmNotificationsSender sender = new FcmNotificationsSender("/topics/all",blood.getText().toString(),
                            message.getText().toString(), getApplicationContext(),NeedBlood.this);

                    sender.SendNotifications();
                    Intent intent = new Intent(NeedBlood.this, Thank_you.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(NeedBlood.this, "Please enter details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
package com.example.lightray;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class controls_activity extends AppCompatActivity {

    private DatabaseReference rotatingBaseStatusRef, motorControlRef, dcMotorRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);

        // Initialize Firebase Realtime Database reference
        rotatingBaseStatusRef = FirebaseDatabase.getInstance().getReference("rotatingBaseStatus");
        motorControlRef = FirebaseDatabase.getInstance().getReference("motorControl");
        dcMotorRef = FirebaseDatabase.getInstance().getReference("dcMotor");

        // Initialize buttons for rotating base control
        Button rotatingBaseOnButton = findViewById(R.id.rotatingBaseOnButton);
        Button rotatingBaseOffButton = findViewById(R.id.rotatingBaseOffButton);
        Button clockwiseButton = findViewById(R.id.clockwiseButton);
        Button anticlockwiseButton = findViewById(R.id.anticlockwiseButton);
        Button dcMotor = findViewById(R.id.buttonOn5Secs);

        // Set click listeners for rotating base control buttons
        rotatingBaseOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRotatingBaseStatus("ON");
                motorControlStatus(true);
            }
        });

        rotatingBaseOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRotatingBaseStatus("OFF");
                motorControlStatus(false);
            }

        });

        clockwiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRotatingBaseStatus("Clockwise");
            }
        });

        anticlockwiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRotatingBaseStatus("Anticlockwise");
            }
        });

        dcMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dcMotorControlStatus(true);
            }
        });
    }

    private void updateRotatingBaseStatus(String status) {
        rotatingBaseStatusRef.setValue(status);
    }
    private void motorControlStatus(Boolean status) {
        motorControlRef.setValue(status);
    }
    private void dcMotorControlStatus(Boolean status) {
        dcMotorRef.setValue(status);
    }
}
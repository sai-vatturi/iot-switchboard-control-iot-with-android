package com.example.lightray;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class leds_activity extends AppCompatActivity {

    private DatabaseReference ledStatusRef;
    private static final int NUM_LEDS = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leds);

        // Initialize Firebase Realtime Database reference
        ledStatusRef = FirebaseDatabase.getInstance().getReference("ledStatus");

        // Set up LED buttons dynamically using a loop
        for (int i = 1; i <= NUM_LEDS; i++) {
            setUpLedButton(i);
        }

        // Set up "All Lights On" button
        MaterialButton allLightsOnButton = findViewById(R.id.allLightsOnButton);
        allLightsOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllLedStatus("ON");
            }
        });

        // Set up "All Lights Off" button
        MaterialButton allLightsOffButton = findViewById(R.id.allLightsOffButton);
        allLightsOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllLedStatus("OFF");
            }
        });
    }

    private void setUpLedButton(final int ledNumber) {
        int ledOnButtonId = getResources().getIdentifier("ledOnButton" + ledNumber, "id", getPackageName());
        int ledOffButtonId = getResources().getIdentifier("ledOffButton" + ledNumber, "id", getPackageName());

        MaterialButton ledOnButton = findViewById(ledOnButtonId);
        MaterialButton ledOffButton = findViewById(ledOffButtonId);

        ledOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLedStatus(ledNumber, "ON");
            }
        });

        ledOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLedStatus(ledNumber, "OFF");
            }
        });
    }

    private void updateLedStatus(int ledNumber, String state) {
        ledStatusRef.child(String.valueOf(ledNumber)).setValue(state);
    }

    private void setAllLedStatus(String state) {
        for (int i = 1; i <= NUM_LEDS; i++) {
            updateLedStatus(i, state);
        }
    }
}
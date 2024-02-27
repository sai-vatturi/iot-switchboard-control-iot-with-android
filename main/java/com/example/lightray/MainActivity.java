package com.example.lightray;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the buttons
        MaterialButton buttonPlantConditions = findViewById(R.id.buttonPlantConditions);
        MaterialButton buttonControlWavelength = findViewById(R.id.buttonControlWavelength);
        MaterialButton buttonControlRotatingDisc = findViewById(R.id.buttonControlRotatingDisc);
        MaterialButton buttonAutomation = findViewById(R.id.automationButton);
        // Set click listeners for each button
        buttonPlantConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Plant Conditions activity
                Intent intent = new Intent(MainActivity.this, plant_conditions.class);
                startActivity(intent);
            }
        });

        buttonControlWavelength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch LED's activity
                Intent intent = new Intent(MainActivity.this, leds_activity.class);
                startActivity(intent);
            }
        });

        buttonControlRotatingDisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Controls activity
                Intent intent = new Intent(MainActivity.this, controls_activity.class);
                startActivity(intent);
            }
        });
        buttonAutomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Controls activity
                Intent intent = new Intent(MainActivity.this, automation.class);
                startActivity(intent);
            }
        });
    }
}
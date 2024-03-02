package com.example.lightray;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class automation extends AppCompatActivity {

    private EditText lightsOnTimeEditText;
    private EditText lightsOffTimeEditText;
    private EditText waterPumpFrequencyEditText;
    private EditText desiredTempEditText;
    private EditText wavelengthEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automation);

        lightsOnTimeEditText = findViewById(R.id.lightsOnTimeEditText);
        lightsOffTimeEditText = findViewById(R.id.lightsOffTimeEditText);
        waterPumpFrequencyEditText = findViewById(R.id.waterPumpFrequencyEditText);
        desiredTempEditText = findViewById(R.id.desiredTempEditText);
        wavelengthEditText = findViewById(R.id.wavelengthEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lightsOnTime = lightsOnTimeEditText.getText().toString();
                String lightsOffTime = lightsOffTimeEditText.getText().toString();
                int waterPumpFrequency = Integer.parseInt(waterPumpFrequencyEditText.getText().toString());
                double desiredTemperature = Double.parseDouble(desiredTempEditText.getText().toString());
                String wavelengths = wavelengthEditText.getText().toString();

                // Perform actions with the gathered input (e.g., send to server, control hardware)
            }
        });
    }
}

package com.example.lightray;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class plant_conditions extends AppCompatActivity {

    private TextView temperatureTextView;
    private TextView humidityTextView;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_conditions);

        temperatureTextView = findViewById(R.id.temperatureTextView);
        humidityTextView = findViewById(R.id.humidityTextView);

        // Initialize the Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("/sensorData");

        // Add a listener to retrieve data from the database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double temperature = dataSnapshot.child("temperature").getValue(Double.class);
                Double humidity = dataSnapshot.child("humidity").getValue(Double.class);


                // Update the TextViews with retrieved data
                temperatureTextView.setText("Temperature: " + temperature + "°C");
                humidityTextView.setText("Humidity: " + humidity + "%");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors that occur
            }
        });
    }
}

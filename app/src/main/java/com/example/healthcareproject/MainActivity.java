package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.healthcareproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Toolbar in your layout by its ID
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Set the Toolbar as the ActionBar
        setSupportActionBar(toolbar);

        // Customize the ActionBar if needed
        getSupportActionBar().setTitle("My App Title"); // Set the title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable the back button
        // Add other customization as needed
    }
}

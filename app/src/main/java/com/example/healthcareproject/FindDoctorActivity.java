package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));

            }
        });

        CardView familyphysician = findViewById(R.id.cardFDFamilyPhisician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);

            }
        });

        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);

            }
        });
        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);

            }
        });


        CardView surgeon  = findViewById(R.id.cardFDSurgeon);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);

            }
        });


        CardView cardiologist = findViewById(R.id.cardFDCardiologist);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);

            }
        });
    }
}
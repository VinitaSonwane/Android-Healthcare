package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][] pacakges =
            {
                    {"Package 1 : Full Body Checkup" , "", "","","999"},
                    {"Package 2 : Blood Glucose Fasting" , "", "","","299"},
                    {"Package 3 : COVID-19 AntiBody - IgG" , "", "","","899"},
                    {"Package 4 : Thyroid Check" , "", "","","499"},
                    {"Package 5 : Immunity Check" , "", "","","699"},
            };
    private String[][] package_details = {
            {
                    "Blood Glucose",
                    "Complete Hemogram",
                    "Iron Studies",
                    "Kidney Function Test",
                    "LDH Lactate Dehydrogenase, Serum",
                    "Lipid Profile",
                    "Liver Function Test"
            },
            {
                    "Blood Glucose Fasting"
            },
            {
                    "COVID-19 Antibody - IgG"
            },
            {
                    "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)"
            },
            {
                    "Complete Hemogram",
                    "CRP (C Reactive Protein) Quantitative, Serum",
                    "Iron Studies",
                    "Kidney Function Test",
                    "Vitamin D Total-25 Hydroxy",
                    "Liver Function Test",
                    "Lipid Profile"
            }
    };
    HashMap<String , String> item;
    ArrayList list;
    SimpleAdapter sa ;
    Button btnGOTOCART,btnBack;
    ListView listView;
    private String[][] packages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);


        btnGOTOCART = findViewById(R.id.buttonLTGoToCart);
        btnBack = findViewById(R.id.buttonLTBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this , HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<pacakges.length;i++){
            item.put("line 1" , packages[i][0]);
            item.put("line 2" , packages[i][1]);
            item.put("line 3" , packages[i][2]);
            item.put("line 4" , packages[i][3]);
            item.put("line 5" , " Total Cost:" + packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this ,list ,
                R.layout.multi_lines,
                new String[] {"line 1" , "line 2" , "line 3" , "line 4" , "line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}) ;

        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
               it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);

            }
        });


    }
}
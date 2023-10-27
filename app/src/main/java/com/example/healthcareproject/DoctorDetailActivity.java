package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    public String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile No:9898989898" , "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Pune" , "Exp : 15yrs" , "Mobile No:7598084698" , "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Chinchwad" , "Exp : 10yrs" , "Mobile No:2345367859" , "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Nigdi" , "Exp : 7yrs" , "Mobile No:9876345672" , "500"},
                    {"Doctor Name : Ashok Pande", "Hospital Address : Katraj" , "Exp : 12yrs" , "Mobile No:5746382910" , "800"},

            };
    public String[][] doctor_details2 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile No:9898989898" , "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Pune" , "Exp : 15yrs" , "Mobile No:7598084698" , "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Chinchwad" , "Exp : 10yrs" , "Mobile No:2345367859" , "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Nigdi" , "Exp : 7yrs" , "Mobile No:9876345672" , "500"},
                    {"Doctor Name : Ashok Pande", "Hospital Address : Katraj" , "Exp : 12yrs" , "Mobile No:5746382910" , "800"},

            };
    public String[][] doctor_details3 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile No:9898989898" , "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Pune" , "Exp : 15yrs" , "Mobile No:7598084698" , "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Chinchwad" , "Exp : 10yrs" , "Mobile No:2345367859" , "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Nigdi" , "Exp : 7yrs" , "Mobile No:9876345672" , "500"},
                    {"Doctor Name : Ashok Pande", "Hospital Address : Katraj" , "Exp : 12yrs" , "Mobile No:5746382910" , "800"},

            };
    public String[][] doctor_details4 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile No:9898989898" , "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Pune" , "Exp : 15yrs" , "Mobile No:7598084698" , "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Chinchwad" , "Exp : 10yrs" , "Mobile No:2345367859" , "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Nigdi" , "Exp : 7yrs" , "Mobile No:9876345672" , "500"},
                    {"Doctor Name : Ashok Pande", "Hospital Address : Katraj" , "Exp : 12yrs" , "Mobile No:5746382910" , "800"},

            };
    public String[][] doctor_details5 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile No:9898989898" , "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Pune" , "Exp : 15yrs" , "Mobile No:7598084698" , "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Chinchwad" , "Exp : 10yrs" , "Mobile No:2345367859" , "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Nigdi" , "Exp : 7yrs" , "Mobile No:9876345672" , "500"},
                    {"Doctor Name : Ashok Pande", "Hospital Address : Katraj" , "Exp : 12yrs" , "Mobile No:5746382910" , "800"},

            };
TextView tv ;
Button btn ;
String[][] doctor_details = {};
ArrayList list;
SimpleAdapter sa;
HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewDDtitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title != null) {
            if (title.equals("Family Physician")) {
                doctor_details = doctor_details1;
            } else
                if (title.equals("Dietitian")) {
                doctor_details = doctor_details2;
            } else
                if (title.equals("Dentist")) {
                doctor_details = doctor_details3;
            } else
                if (title.equals("Surgeon")) {
                doctor_details = doctor_details4;
            } else {
                doctor_details = doctor_details5;
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Consultation Fees: " + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i , long l) {
                Intent it = new Intent(DoctorDetailActivity.this , BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);



            }
        });
    }

}
package com.example.controlinput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDetailsActivity extends AppCompatActivity {

    private TextView nameTV,ageTV,skillTV,genderTV,cityTV,phoneTV,emailTV,dobTV;
    private ImageView CALLIV,EMAILIV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        nameTV = findViewById(R.id.empNameValue);
        ageTV  = findViewById(R.id.empAgeValue);
        skillTV= findViewById(R.id.empSkillValue);
        genderTV= findViewById(R.id.empGenValue);
        phoneTV = findViewById(R.id.showPhone);
        emailTV = findViewById(R.id.showEmail);
        dobTV = findViewById(R.id.empDobValue);
        CALLIV = findViewById(R.id.callIV);
        EMAILIV = findViewById(R.id.mailIV);
        cityTV = findViewById(R.id.empCityValue);


        Intent intent = getIntent();
        Employee employee = (Employee) intent.getSerializableExtra("emp");

        try {
            nameTV.setText(employee.getName());
            ageTV.setText(employee.getAge());
            genderTV.setText(employee.getGender());
            phoneTV.setText(employee.getPHONE());
            emailTV.setText(employee.getEMAIL());
            cityTV.setText(employee.getCity());
            dobTV.setText(employee.getDob());
            String skills = TextUtils.join(", ",employee.getLanguage());
            skillTV.setText(skills);


        }catch (NullPointerException e){
            Toast.makeText(this, "Invalid Object", Toast.LENGTH_SHORT).show();

        }

        CALLIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+employee.getPHONE()));

                    startActivity(callIntent);

            }
        });

        EMAILIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("*/*");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{employee.getEMAIL()});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"This is test");


                startActivity(emailIntent);


            }
        });

















    }







    public void updateEmployee(View view) {
    }




}
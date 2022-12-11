package com.example.controlinput;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<String>language = new ArrayList<>();
    private RadioGroup radioGroup;
    private String gender ="Male";
    private EditText nameET,ageET,phoneET,emailET;
    private Spinner citySP;
    private String city,dob;
    private Button dobBtn;
    private Calendar calendar;
    private int year,month,day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.empName);
        ageET  = findViewById(R.id.empAge);
        phoneET = findViewById(R.id.empphnone);
        emailET = findViewById(R.id.empEmail);
        radioGroup = findViewById(R.id.genderRG);
        citySP = findViewById(R.id.citySP);
        dobBtn =findViewById(R.id.empDob);
        calendar = Calendar.getInstance(Locale.getDefault());

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_row,R.id.cityName,
                getCities());
        citySP.setAdapter(adapter);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                RadioButton rb = findViewById(i);
                gender = rb.getText().toString();
                //Toast.makeText(MainActivity.this, rb.getText().toString(), Toast.LENGTH_LONG).show();

            }
        });

        citySP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 city = parent.getItemAtPosition(position).toString();
               // Toast.makeText(MainActivity.this,city, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       // citySP.setSelection(getCities().indexOf("Bogra"));
    }








    public void SelectLanguage(View view) {
        CheckBox cb = (CheckBox) view;
        boolean isChecked =cb.isChecked();
        String selectedLanguage = cb.getText().toString();
        if (isChecked){
            language.add(selectedLanguage);
        }else {
            language.remove(selectedLanguage);
        }

        for (String s: language){
            Log.e("test","list: "+s);
        }

    }

    public void registerEmployee(View view) {

        String name = nameET.getText().toString();
        String age  = ageET.getText().toString();
        String phn = phoneET.getText().toString();
        String mail= emailET.getText().toString();


        Employee employee = new Employee(name,age,gender,language,city,phn,mail,dob);
        Employee.addEmployeeToList(employee);

        //Explicit intent
        Intent intent = new Intent(MainActivity.this,EmployeeListActivity.class);
       // intent.putExtra("emp",employee);
        startActivity(intent);
    }

    private List<String>getCities(){
        List<String>cities = new ArrayList<>();
        cities.add("Dhaka");
        cities.add("Chittagong");
        cities.add("Rajshahi");
        cities.add("Barishal");
        cities.add("Khulna");
        cities.add("Rongpur");
        cities.add("Tangail");
        cities.add("Jamalpur");
        cities.add("Cumilla");
        cities.add("Mymonsing");
        cities.add("Cox Bazar");
        cities.add("Sylet");
        cities.add("Bogra");
        cities.add("Dinajpur");
        cities.add("Noakhali");
        cities.add("Jessore");
        cities.add("Faridpur");
        cities.add("Dhaka");
        cities.add("Modupur");
        cities.add("Rajsahi");
        cities.add("Dhaka");
        cities.add("Dinajpur");
        cities.add("Dhaka");
        cities.add("Habigoj");
        cities.add("Jessore");
        cities.add("Faridpur");
        cities.add("Dhaka");
        cities.add("Modupur");
        cities.add("Rajsahi");
        cities.add("Dhaka");
        cities.add("Dinajpur");
        cities.add("Dhaka");
        cities.add("Habigoj");
        return cities;

    }

    public void selectDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //Toast.makeText(MainActivity.this, "year:"+i+",month:"+i1+",day:"+i2, Toast.LENGTH_SHORT).show();
              /*  StringBuilder builder = new StringBuilder();
                builder.append(i2).append("/").append(i1+1).append("/").append(i);
                Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();*/
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Calendar temp = Calendar.getInstance();
                temp.set(i,i1,i2);
                dob = sdf.format(temp.getTime());
                //Toast.makeText(MainActivity.this, date, Toast.LENGTH_LONG).show();
                dobBtn.setText(dob);

            }


        }, year, month, day);
        datePickerDialog.show();
    }
}
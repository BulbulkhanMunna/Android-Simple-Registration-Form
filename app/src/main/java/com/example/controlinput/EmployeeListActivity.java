package com.example.controlinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {
    TextView msgTV;
    ListView empLV;
    EmployeeAdapter adapter;
    List<Employee>employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        employees= Employee.getListOfEmployee();
        msgTV = findViewById(R.id.emptyListMessage);
        empLV = findViewById(R.id.employeeListView);
        adapter = new EmployeeAdapter(this,employees);
        empLV.setAdapter(adapter);

        if (employees.size()==0){
            msgTV.setVisibility(View.VISIBLE);
        }
        empLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Employee employee = employees.get(i);
                startActivity(new Intent(EmployeeListActivity.this,
                        EmployeeDetailsActivity.class).putExtra("emp",employee));

            }
        });
    }

    public void addNewEmployee(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
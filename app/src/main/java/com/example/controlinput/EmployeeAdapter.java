package com.example.controlinput;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    private Context context;
    private List<Employee>employees;
    public EmployeeAdapter(@NonNull Context context, List<Employee>employees) {
        super(context,R.layout.employee_row,employees);
        this.context = context;
        this.employees= employees;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.employee_row,parent,false);
        TextView rowEmpName = convertView.findViewById(R.id.row_empName);
        TextView rowEmpAge = convertView.findViewById(R.id.row_empAge);
        TextView rowEmpPhn = convertView.findViewById(R.id.row_empPhn);
        TextView rowEmpEmail= convertView.findViewById(R.id.row_empEmail);
        TextView rowEmpSkills= convertView.findViewById(R.id.row_empSkills);

        rowEmpName.setText(employees.get(position).getName());
        rowEmpAge.setText(employees.get(position).getAge());
        rowEmpPhn.setText(employees.get(position).getPHONE());
        rowEmpEmail.setText(employees.get(position).getEMAIL());
        String skills = TextUtils.join(", ",employees.get(position).getLanguage());
        rowEmpSkills.setText(skills);

        return convertView;
    }
}

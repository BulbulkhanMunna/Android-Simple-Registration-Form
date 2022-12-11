package com.example.controlinput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
    private String name;
    private String age;
    private String gender;
    private String city;
    private List<String>language;
    private String PHONE;
    private String EMAIL;
    private String dob;

    private static List<Employee>employees= new ArrayList<>();


    public Employee(String name, String age, String gender, List<String> language,String city,String PHONE,String EMAIL,String dob) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.language = language;
        this.PHONE =PHONE;
        this.EMAIL =EMAIL;
        this.dob = dob;



    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }



    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public List<String> getLanguage() {
        return language;
    }

    public String getPHONE() {
        return PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getDob() {
        return dob;
    }

    public static void addEmployeeToList(Employee employee){
        employees.add(employee);
    }

    public static List<Employee>getListOfEmployee(){
        return employees;
    }
}

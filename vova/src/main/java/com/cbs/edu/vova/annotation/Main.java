package com.cbs.edu.vova.annotation;

/**
 * Created by User on 19.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Employee vasya = new Employee(null, 55, "Bogatyrska str.", "vasya@gamil.com", true);
        EmployeeValidator validator = new EmployeeValidator();
        validator.validate(vasya);
    }
}

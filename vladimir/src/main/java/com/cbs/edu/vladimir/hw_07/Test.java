package com.cbs.edu.vladimir.hw_07;

import java.lang.reflect.Field;

/**
 * Created by Vladimir on 20.04.2017.
 */
public class Test {
    public static void main(String[] args) {

        String employeeName = "Katya";

        Employee katya = new Employee(employeeName, 29, true);

        Validator validator = new Validator();
        validator.validate(katya);
    }
}




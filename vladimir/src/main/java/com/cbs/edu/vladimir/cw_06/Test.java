package com.cbs.edu.vladimir.cw_06;

import java.lang.reflect.Field;

/**
 * Created by Vladimir on 19.04.2017.
 */
public class Test {
    /**
     * Main.
     */
    public static void main(String[] args) {
        final int vladimirAge = 20;
        Employee vladimir = new Employee("Vladimir", vladimirAge);

        Class aClass = vladimir.getClass();
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getName());

        System.out.println(vladimir.getName());
        try {
            Field nameField = aClass.getDeclaredField("name");
            nameField.setAccessible(true);
            System.out.println(nameField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}

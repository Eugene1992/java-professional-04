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
        Employee vladimir = new Employee("Vladimir", 20);

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

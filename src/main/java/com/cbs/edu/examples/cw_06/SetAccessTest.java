package com.cbs.edu.examples.cw_06;

import java.lang.reflect.Field;

public class SetAccessTest {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", 22, 1.85f, true);
        Class aClass = ivan.getClass();

        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getPackage());

        System.out.println(ivan.getName());

        try {
            Field nameField = aClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(ivan, "Larisa");
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(ivan.getName());
    }
}
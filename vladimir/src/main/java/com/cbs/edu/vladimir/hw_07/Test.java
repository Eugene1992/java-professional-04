package com.cbs.edu.vladimir.hw_07;

import java.lang.reflect.Field;

/**
 * Created by Vladimir on 20.04.2017.
 */
public class Test {
    public static void main(String[] args) {
/**
 * Testing.
 */
        String employeeName = "Katya";

        Employee katya = new Employee(employeeName, 29, true);


        Class<? extends Employee> aClass = katya.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(NotNull.class)) {
                NotNull annotation = declaredField.getAnnotation(NotNull.class);
                String notNullName = annotation.name();
                if (notNullName.equals(katya.getName())) {
                    System.out.println("name is true");
                } else {
                    System.out.println("name is not true");
                }
            }


            if (declaredField.isAnnotationPresent(Min.class)) {
                Min secondAnnotation = declaredField.getAnnotation(Min.class);
                int minAge = secondAnnotation.minAge();
                if ((minAge <= katya.getAge())) {
                    System.out.println("age >= minAge");
                } else {
                    System.out.println("age is not true");
                }
            }
            if (declaredField.isAnnotationPresent(Max.class)) {
                Max thirdAnnotation = declaredField.getAnnotation(Max.class);
                int maxAge = thirdAnnotation.maxAge();
                if ((katya.getAge() <= maxAge)) {
                    System.out.println("age <= maxAge");
                } else {
                    System.out.println("age is not true");
                }

            }
            if (declaredField.isAnnotationPresent(AssertTrue.class)) {
                AssertTrue fourthAnnotation = declaredField.getAnnotation(AssertTrue.class);
                boolean trueOrFalse = fourthAnnotation.trueOrFalse();
                if (trueOrFalse == katya.isMarried()) {
                    System.out.println("single");
                } else {
                    System.out.println("married");
                }
            }
        }
    }
}




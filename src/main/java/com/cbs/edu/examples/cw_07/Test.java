package com.cbs.edu.examples.cw_07;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", 22, 1.85f, true);

        Class<? extends Employee> aClass = ivan.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = declaredField.getAnnotation(MyAnnotation.class);
                String message = annotation.message();
                int value = annotation.value();
                System.out.println(declaredField.getName() + " message=[" + message + "]," + " value=[" + value + "]" );
            }
        }
    }
}

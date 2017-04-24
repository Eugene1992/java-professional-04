package com.cbs.edu.vladimir.hw_07;

import java.lang.reflect.Field;
import java.util.Collection;

public class Validator {

    public void validate(Object object) {
        Class aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(NotNull.class)) {
                NotNull annotation = declaredField.getAnnotation(NotNull.class);
                String notNullName = annotation.name();
                if (notNullName.equals(aClass.getName())) {
                    System.out.println("name is true");
                } else {
                    throw new EmployeeException("");
                }
            }

            if (declaredField.isAnnotationPresent(Min.class)) {
                Min secondAnnotation = declaredField.getAnnotation(Min.class);
                int minAge = secondAnnotation.minAge();

            }
            if (declaredField.isAnnotationPresent(Max.class)) {
                Max thirdAnnotation = declaredField.getAnnotation(Max.class);
                int maxAge = thirdAnnotation.maxAge();

            }
            if (declaredField.isAnnotationPresent(AssertTrue.class)) {
                AssertTrue fourthAnnotation = declaredField.getAnnotation(AssertTrue.class);
                boolean trueOrFalse = fourthAnnotation.trueOrFalse();

            }
        }
    }

    public void validate(Collection<Object> object) {

    }
}

package com.cbs.edu.vova.annotation;

import java.lang.reflect.Field;
import java.util.Collection;


/**
 * Created by User on 19.04.2017.
 */
public class EmployeeValidator implements Validator {

    @Override
    public boolean validate(Object obj) {
        Class<? extends Object> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            startValidation(declaredField, obj);
        }
        return true;
    }

    @Override
    public boolean validate(Collection type) {
        return false;
    }

    /**
     * Method which start validation.
     *
     * @param declaredField Field which we validate.
     * @param obj           Object whom fields we validate.
     */
    public void startValidation(Field declaredField, Object obj) {
        notNullAnnotation(declaredField, obj);
        sizeAnnotation(declaredField, obj);
        maxAnnotation(declaredField, obj);
        minAnnotation(declaredField, obj);
        assertTrueAnnotation(declaredField, obj);
    }

    /**
     * Method which proccesses NotNull annotation.
     *
     * @param declaredField Field which we validate.
     * @param obj           Object whom fields we validate.
     */
    private void notNullAnnotation(Field declaredField, Object obj) {
        if (declaredField.isAnnotationPresent(NotNull.class)) {
            NotNull annotation = declaredField.getAnnotation(NotNull.class);
            declaredField.setAccessible(true);
            String message = annotation.message();
            try {
                if (declaredField.get(obj) == null) {
                    throw new MyException(message);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method which proccesses Size annotation.
     *
     * @param declaredField Field which we validate.
     * @param obj           Object whom fields we validate.
     */
    public void sizeAnnotation(Field declaredField, Object obj) {
        if (declaredField.isAnnotationPresent(Size.class)) {
            Size annotation = declaredField.getAnnotation(Size.class);
            String message = annotation.message();
            try {
                String str = (String) declaredField.get(obj);
                if (str.length() > annotation.size()) {
                    throw new MyException(message);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method which proccesses Max annotation.
     *
     * @param declaredField Field which we validate.
     * @param obj           Object whom fields we validate.
     */
    public void maxAnnotation(Field declaredField, Object obj) {
        if (declaredField.isAnnotationPresent(Max.class)) {
            Max annotation = declaredField.getAnnotation(Max.class);
            String message = annotation.message();
            try {
                int value = (int) declaredField.get(obj);
                if (value > annotation.maxSize()) {
                    throw new MyException(message);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method which proccesses Min annotation.
     *
     * @param declaredField Field which we validate.
     * @param obj           Object whom fields we validate.
     */
    public void minAnnotation(Field declaredField, Object obj) {
        if (declaredField.isAnnotationPresent(Min.class)) {
            Min annotation = declaredField.getAnnotation(Min.class);
            String message = annotation.message();
            try {
                int value = (int) declaredField.get(obj);
                if (value < annotation.minSize()) {
                    throw new MyException(message);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method which proccesses AssertTrue annotation.
     *
     * @param declaredField Field which we validate.
     * @param obj           Object whom fields we validate.
     */
    public void assertTrueAnnotation(Field declaredField, Object obj) {
        if (declaredField.isAnnotationPresent(AssertTrue.class)) {
            AssertTrue annotation = declaredField.getAnnotation(AssertTrue.class);
            String message = annotation.message();
            try {
                boolean value = (boolean) declaredField.get(obj);
                if (value) {
                    throw new MyException(message);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

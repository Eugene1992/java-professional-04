
package com.cbs.edu.examples.cw_06;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetFieldsTest {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", 22, 1.85f, true);
        Class aClass = ivan.getClass();

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            int modifiers = declaredField.getModifiers();
            if (Modifier.isPrivate(modifiers)) {
                System.out.print("private ");
            }
            if (Modifier.isStatic(modifiers)) {
                System.out.print("static ");
            }
            try {
                System.out.println(type.getSimpleName() + " " + declaredField.getName() + " = " + declaredField.get(ivan));
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
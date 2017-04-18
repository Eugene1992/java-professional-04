
package com.cbs.edu.examples.cw_06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethodsTest {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", 22, 1.85f, true);
        Class aClass = ivan.getClass();
//        ivan.sayHello();

        try {
            Method sayHello = aClass.getDeclaredMethod("sayHello");
            sayHello.setAccessible(true);
            sayHello.invoke(ivan);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }
}
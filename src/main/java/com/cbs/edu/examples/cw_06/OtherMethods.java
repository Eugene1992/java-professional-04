package com.cbs.edu.examples.cw_06;

public class OtherMethods {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", 22, 1.85f, true);
        Class aClass = ivan.getClass();
        int[] ints = {};
        Class arrayClass = ints.getClass();

        System.out.println(aClass.isPrimitive());
        System.out.println(aClass.isAnnotation());
        System.out.println(aClass.isArray());

        System.out.println(arrayClass.isArray());

        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        Class superclass = aClass.getSuperclass();
        System.out.println(superclass.getSimpleName());

    }
}

package com.cbs.edu.examples.cw_06;

public class CreateInstance {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", 22, 1.85f, true);
        Class aClass = ivan.getClass();
        Class aClazz = Employee.class;

        try {
            Employee newEmployee = (Employee) aClazz.newInstance();
            System.out.println(newEmployee);
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

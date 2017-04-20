package com.cbs.edu.vladimir.cw_06;

/**
 * Created by Vladimir on 19.04.2017.
 */
public class Employee {

    private String name;
    private int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String
    toString() {
        return "Employee{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

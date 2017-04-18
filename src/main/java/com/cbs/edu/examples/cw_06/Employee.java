package com.cbs.edu.examples.cw_06;

import java.io.Closeable;
import java.io.Serializable;

public class Employee implements Serializable, Cloneable {

    private String name;
    private int age;
    private float height;
    private boolean isMarried;

    public Employee(String name, int age, float height, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.isMarried = isMarried;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isMarried() {
        return isMarried;
    }

    private void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isMarried=" + isMarried +
                '}';
    }
}

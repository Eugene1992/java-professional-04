package com.cbs.edu.examples.cw_03;

public class Employee {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (Float.compare(employee.height, height) != 0) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (height != +0.0f ? Float.floatToIntBits(height) : 0);
        return result;
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

package com.cbs.edu.examples.cw_02;

public class Employee implements Comparable<Employee> {

    private String firstName;
    private int age;

    public Employee(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.firstName.compareTo(emp.firstName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}

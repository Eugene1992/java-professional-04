package com.cbs.edu.vladimir.cw_02;

/**
 * Created by Vladimir on 11.04.2017.
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee tmp) {
        if (tmp.age > this.age) {
            return 1;
        }
        if (tmp.age < this.age) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}

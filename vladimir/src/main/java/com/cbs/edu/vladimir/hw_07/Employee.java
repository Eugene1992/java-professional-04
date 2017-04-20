package com.cbs.edu.vladimir.hw_07;


/**
 * Created by Vladimir on 19.04.2017.
 */
public class Employee {

    @NotNull(name = "Katya")
    private String name;

    @Min(message = "minAge")
    @Max(message = "maxAge")
    private int age;


    @AssertTrue(message = "isMarried ? ")
    private boolean isMarried;

    public Employee(String name, int age, boolean isMarried) {
        this.name = name;
        this.age = age;
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


    public boolean isMarried() {
        return isMarried;
    }

    private void sayHello() {
        System.out.println("Hello, my name is " + name);
    }


    @Override
    public String toString() {
        return "Employee{" + "age=" + age + ", name='" + name + '\'' + ", isMarried=" + isMarried + '}';
    }
}

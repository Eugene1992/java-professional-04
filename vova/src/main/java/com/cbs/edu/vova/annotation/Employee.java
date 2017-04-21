package com.cbs.edu.vova.annotation;

/**
 * Created by User on 19.04.2017.
 */
public class Employee {

    @NotNull(message = "Name cant be empty") @Max(maxSize = 20, message = "Max length for name is 15")
    private String name;
    @NotNull(message = "Age cant be empty") @Max(maxSize = 20, message = "Max age for user is 95")
    @Min(minSize = 18, message = "Min age for user 18")
    private int age;
    @Size(size = 30, message = "Max length for address is 30")
    private String address;
    @Size(size = 20, message = "Max length for email is 10")
    private String email;
    @AssertTrue(message = "Sorry we don't communicate with aliens")
    private boolean isHuman;

    public Employee(String name, int age, String address, String email, boolean isHuman) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }
}

package com.cbs.edu.Validation;

public class Employee {
    @NotNull
    @Size(value = 20, message = "max size")
    private String name;
    @NotNull
    @Min(value = 18, message = "Min Age")
    @Max(value = 40, message = "Max Age")
    private int age;
    @NotNull
    @Min(value = 100, message = "Min Height")
    @Max(value = 250, message = "Max Height")
    private float height;
    @NotNull
    private boolean isMarried;
}

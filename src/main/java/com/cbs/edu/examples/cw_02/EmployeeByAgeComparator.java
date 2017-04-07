package com.cbs.edu.examples.cw_02;

import java.util.Comparator;

public class EmployeeByAgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
    }
}

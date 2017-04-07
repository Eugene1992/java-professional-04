package com.cbs.edu.examples.cw_02;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Employee vova = new Employee("Vova", 22);
        Employee dima = new Employee("Dima", 17);
        Employee sasha = new Employee("Sasha", 30);
        Employee[] employeesArray = {vova, dima, sasha};

        List<Employee> employeeList = Arrays.asList(vova, dima, sasha);
        System.out.println(employeeList);

        Collections.sort(employeeList);

        System.out.println(employeeList);

        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(employeeList);


        Deque<Object> objects = new LinkedList<>();
    }
}

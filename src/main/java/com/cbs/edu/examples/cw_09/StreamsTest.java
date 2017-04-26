package com.cbs.edu.examples.cw_09;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    public List<Employee> employees;

    @Before
    public void setUp() {
        Employee ivan = new Employee("Ivan", "", 22, 15000, "");
        Employee dasha = new Employee("Dasha", "", 20, 25000, "");
        Employee kolya = new Employee("Kolya", "", 32, 45000, "");
        Employee taras = new Employee("Taras", "", 42, 15000, "");
        Employee vitalik = new Employee("Vitalik", "", 18, 5000, "");
        Employee vitalik2 = new Employee("Vitalik", "", 18, 5000, "");

        employees = Arrays.asList(ivan, dasha, kolya, taras, vitalik, vitalik2);
    }

    @Test
    public void distinctTest() {
        employees
                .stream()
                .distinct()
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void skipTest() {
        employees
                .stream()
                .skip(3)
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void mapTest() {
        employees
                .stream()
                .map(new Function<Employee, Integer>() {
                    @Override
                    public Integer apply(Employee employee) {
                        return employee.getAge();
                    }
                })
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void peekTest() {
        employees
                .stream()
                .peek(employee -> employee.salary = employee.salary + 10000)
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void limitTest() {
        employees
                .stream()
                .limit(2)
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void sortedTest() {
        List<Employee> collect = employees
                .stream()
                .sorted((o1, o2) -> o1.salary - o2.salary)
                .collect(Collectors.toList());
    }

    /*@Test
    public void employeeProcessing() throws IOException {
        Files
                .readAllLines(Paths.get("emp_mock.txt"))
                .stream()
                .flatMap((p) -> Arrays.stream(p.split(",")))

    }*/



    static class Employee {
        String firstName;
        String lastName;
        int age;
        int salary;
        String gender;

        public Employee(String firstName, String lastName, int age, int salary, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public int getSalary() {
            return salary;
        }

        public String getGender() {
            return gender;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            if (age != employee.age) return false;
            if (salary != employee.salary) return false;
            if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
            if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
            return gender != null ? gender.equals(employee.gender) : employee.gender == null;
        }

        @Override
        public int hashCode() {
            int result = firstName != null ? firstName.hashCode() : 0;
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + age;
            result = 31 * result + salary;
            result = 31 * result + (gender != null ? gender.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}

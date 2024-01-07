package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {
    private String firstName;
    private String lastName;
    private String address;
    private double salary;
    private List<Car> carRentList;

    public Employee(String firstName, String lastName, String address, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
        carRentList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public List<Car> getCarList() {
        return carRentList;
    }

    public void rentCar(Car car) {
        carRentList.add(car);
    }

    public void countRentCar() {
        Map<Car, Long> counterOfRent = new HashMap<>();
        for (Car car : carRentList) {
            Long count = counterOfRent.getOrDefault(car, 0L);
            counterOfRent.put(car, count + 1);
        }
        for (Map.Entry<Car, Long> entry : counterOfRent.entrySet()) {
            System.out.println(firstName + " " + lastName + " used car: " + entry.getKey().toString() + " for: " + entry.getValue());
        }
    }
}

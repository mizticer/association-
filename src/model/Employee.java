package model;

import java.util.Date;

public class Employee extends Person {
    private Date startDate;
    private EmployeeType employeeType;

    public Employee(String firstName, String lastName, String address, Date startDate, EmployeeType employeeType) {
        super(firstName, lastName, address);
        this.startDate = startDate;
        this.employeeType = employeeType;
    }

    public void promoteToManager() {
        if (employeeType == EmployeeType.SERVICE) {
            employeeType = EmployeeType.MANAGER;
        } else {
            throw new IllegalStateException("Cannot promote manager to manager!");
        }
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "startDate=" + startDate +
                ", employeeType=" + employeeType +
                '}';
    }
}

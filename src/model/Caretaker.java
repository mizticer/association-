package model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import static util.Constants.MINIMUM_WAGE;

@SuperBuilder
@Getter
public class Caretaker extends Person {
    private double salary;
    private TypeCaretaker typeCaretaker;

    public Caretaker(String firstName, String lastName, Date dateOfBirth, double salary, TypeCaretaker typeCaretaker) {
        super(firstName, lastName, dateOfBirth);
        this.typeCaretaker = typeCaretaker;
        calculateSalary();
    }

    public double calculateSalary() {
        if (this.typeCaretaker.equals(TypeCaretaker.QUALIFIED)) {
            salary = MINIMUM_WAGE + 500;
        } else {
            salary = MINIMUM_WAGE;
        }
    }
}

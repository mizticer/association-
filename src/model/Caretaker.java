package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static util.Constants.MINIMUM_WAGE;

public class Caretaker extends Person {
    private double salary;
    private TypeCaretaker typeCaretaker;
    private List<Group> groupList;

    public Caretaker(String firstName, String lastName, Date dateOfBirth, TypeCaretaker typeCaretaker) {
        super(firstName, lastName, dateOfBirth);
        this.typeCaretaker = typeCaretaker;
        groupList = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groupList.add(group);
        group.setCaretaker(this);
        calculateSalary();
    }

    private void calculateSalary() {
        int numberOfGroup = groupList.size();
        if (this.typeCaretaker.equals(TypeCaretaker.QUALIFIED)) {
            salary = MINIMUM_WAGE + 500 + numberOfGroup * 100;
        } else {
            salary = MINIMUM_WAGE + numberOfGroup * 100;
        }
    }

    public double getSalary() {
        return salary;
    }

    public TypeCaretaker getTypeCaretaker() {
        return typeCaretaker;
    }

    public void setTypeCaretaker(TypeCaretaker typeCaretaker) {
        this.typeCaretaker = typeCaretaker;
        calculateSalary();
    }

    public List<Group> getGroupList() {
        return groupList;
    }
}

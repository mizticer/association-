package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static util.Constants.MINIMUM_WAGE;

public class Caretaker extends Person {
    private List<Group> groupList;

    public Caretaker(String firstName, String lastName, Date dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
        groupList = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groupList.add(group);
        group.setCaretaker(this);
    }

    public double getSalary() {
        return MINIMUM_WAGE + groupList.size() * 100;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

}

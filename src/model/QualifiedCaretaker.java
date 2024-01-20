package model;

import java.util.Date;
import java.util.List;

public class QualifiedCaretaker extends Caretaker{
    private List<String> qualificationList;
    public QualifiedCaretaker(String firstName, String lastName, Date dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    @Override
    public double getSalary() {
        return super.getSalary()+500.0+qualificationList.size()+10.0;
    }
}

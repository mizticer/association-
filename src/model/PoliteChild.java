package model;

import java.util.Date;

public class PoliteChild extends Child {
    private String badge;

    public PoliteChild(String firstName, String lastName, Date dateOfBirth, String badge) {
        super(firstName, lastName, dateOfBirth);
        this.badge = badge;
    }

}

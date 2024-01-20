package model;

import java.util.Date;
import java.util.List;

public class RudeChild extends Child {
    private List<String> offencesList;

    public RudeChild(String firstName, String lastName, Date dateOfBirth, List<String> offencesList) {
        super(firstName, lastName, dateOfBirth);
        this.offencesList = offencesList;
    }

    public void addOffecne(String offence) {
        offencesList.add(offence);
    }

    public List<String> getOffences() {
        return offencesList;
    }
}

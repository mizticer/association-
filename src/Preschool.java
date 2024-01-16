import model.Caretaker;
import model.Child;
import model.Group;
import model.TypeCaretaker;

import java.util.ArrayList;
import java.util.List;

public class Preschool {
    private List<Caretaker> caretakers;
    private List<Group> groups;

    public List<Caretaker> getQualifiedCaretakersWithSalaryGreaterThan(double minSalary) {
        List<Caretaker> qualifiedCaretakers = new ArrayList<>();

        for (Caretaker caretaker : caretakers) {
            if (caretaker.getTypeCaretaker() == TypeCaretaker.QUALIFIED && caretaker.getSalary() > minSalary) {
                qualifiedCaretakers.add(caretaker);
            }
        }
        return qualifiedCaretakers;
    }

    public Child findChildWithMostOffencesFromSchool() {
        if (groups.isEmpty()) {
            return null;
        }
        Child childWithMostOffences = groups.get(0).getChildWithMostOffencesFromGroup();

        for (Group group : groups) {
            if (group.getChildWithMostOffencesFromGroup().getOffences() > childWithMostOffences.getOffences()) {
                childWithMostOffences = group.getChildWithMostOffencesFromGroup();
            }
        }
        return childWithMostOffences;
    }
}



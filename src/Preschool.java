import model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Preschool {
    private List<Caretaker> caretakers;
    private List<Group> groups;

    public Preschool() {
        caretakers = new ArrayList<>();
        groups = new ArrayList<>();
    }

    public void addCaretaker(Caretaker caretaker) {
        caretakers.add(caretaker);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Caretaker> getQualifiedCaretakersWithSalaryGreaterThan(double minSalary) {
        List<Caretaker> qualifiedCaretakers = new ArrayList<>();

        for (Caretaker caretaker : caretakers) {
            if (caretaker instanceof QualifiedCaretaker && caretaker.getSalary() > minSalary) {
                qualifiedCaretakers.add(caretaker);
            }
        }
        return qualifiedCaretakers;
    }

//    public Child findChildWithMostOffencesFromSchool() {
//        if (groups.isEmpty()) {
//            throw new IllegalStateException();
//        }
//        Child childWithMostOffences = groups.get(0).getChildWithMostOffences();
//
//        // TODO: 20.01.2024 : dokończyć za pomocą pętli
////        for (Group group : groups) {
////            if (group.getChildWithMostOffences().getOffences() > childWithMostOffences.getOffences()) {
////                childWithMostOffences = group.getChildWithMostOffences();
////            }
////        }
//        return childWithMostOffences;
//    }

    public RudeChild findChildWithMostOffencesFromSchool() {
        return groups.stream()
                .flatMap(group -> group.getChildren().stream())
                .filter(child -> child instanceof RudeChild)
                .map(child -> (RudeChild) child)
                .max(Comparator.comparingInt(child -> child.getOffences().size()))
                .orElseThrow();
    }

    public void saveChildrenToFile(Caretaker caretaker) {
        if (!caretakers.contains(caretaker)) {
            throw new IllegalArgumentException();
        }
        List<Group> groupList = caretaker.getGroupList();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("children.txt"))) {
            for (Group group : groupList) {
                writer.write(group.getName());
                writer.newLine();
                for (Child child : group.getChildren()) {
                    writer.write(child.getFullName());
                    writer.newLine();
                }
            }
            System.out.println("Data about children saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



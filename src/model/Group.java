package model;

import util.Constants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Child> children;
    private String name;
    private int maxChildren;
    private Caretaker caretaker;
    private Room room;

    public Group(String name) {
        this.name = name;
        this.maxChildren = Constants.MAX_CHILDREN_IN_GROUP;
        this.children = new ArrayList<>();
    }

    public void addChild(Child child) {
        if (children.size() < maxChildren) {
            children.add(child);
            child.setGroup(this);
        } else {
            System.out.println("This group is full");
        }
    }

    public void setRoom(Room room) {
        this.room = room;
        room.setGroup(this);
    }

    public List<Child> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public Child getChildWithMostOffencesFromGroup() {
        if (children.isEmpty()) {
            throw new IllegalStateException();
        }
        Child childWithMostOffences = children.get(0);

        for (Child child : children) {
            if (child.getOffences() > childWithMostOffences.getOffences()) {
                childWithMostOffences = child;
            }
        }
        return childWithMostOffences;
    }

}

package model;

import util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Group {
    private List<Child> children;
    private String name;
    private Caretaker caretaker;
    private Room room;

    public Group(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Child child) {
        if (children.size() <  Constants.MAX_CHILDREN_IN_GROUP) {
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

    public Child getChildWithMostOffences() {
        if (children.isEmpty()) {
            throw new IllegalStateException();
        }
        RudeChild childWithMostOffences = findRudeChild();

        for (Child child : children) {
            if (child instanceof RudeChild && ((RudeChild) child).getOffences().size() > childWithMostOffences.getOffences().size()) {
                childWithMostOffences = (RudeChild) child;
            }
        }
        return childWithMostOffences;
    }

    private RudeChild findRudeChild() {
        for (Child child : children) {
            if (child instanceof RudeChild) {
                return (RudeChild) child;
            }
        }
        throw new NoSuchElementException("No RudeChild in this group");
    }

}

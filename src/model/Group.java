package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Group {
    private Set<Child> kids = new HashSet<>();
    private String name;
    private int maxChildren;
    private Caretaker caretaker;
}

package model;

public class Room {
    private String name;
    private String wallColor;
    private Group group;

    public Room(String name, String wallColor) {
        this.name = name;
        this.wallColor = wallColor;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

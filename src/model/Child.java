package model;

import java.util.Date;

public class Child extends Person {
    private int offences;
    private TypeKid typeKid;
    private Group group;

    public Child(String firstName, String lastName, Date dateOfBirth, int offences) {
        super(firstName, lastName, dateOfBirth);
        this.offences = offences;
        checkBehaviour();
    }

    public int getOffences() {
        return offences;
    }

    public void setOffences(int offences) {
        this.offences = offences;
        checkBehaviour();
    }

    public TypeKid getTypeKid() {
        return typeKid;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private void checkBehaviour() {
        if (this.offences > 3) {
            this.typeKid = TypeKid.NO_POLITELY;
        } else {
            this.typeKid = TypeKid.POLITELY;
        }
    }
}

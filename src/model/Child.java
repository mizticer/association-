package model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Getter
public class Child extends Person {
    private int offences;
    private TypeKid typeKid;

    public Child(String firstName, String lastName, Date dateOfBirth, int offences) {
        super(firstName, lastName, dateOfBirth);
        this.offences = offences;
        checkBehaviour();
    }

    private void checkBehaviour() {
        if (this.offences > 3) {
            this.typeKid = TypeKid.NO_POLITELY;
        } else {
            this.typeKid = TypeKid.POLITELY;
        }
    }
}

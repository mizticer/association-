package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}

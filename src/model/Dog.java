package model;

import java.util.List;

public class Dog extends Animal {
    private int furLength;
    private List<String> favouriteToys;

    public Dog(String name, String species, int furLength, List<String> favouriteToys) {
        super(name, species);
        this.furLength = furLength;
        this.favouriteToys = favouriteToys;
    }
}

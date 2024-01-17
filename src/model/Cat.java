package model;

public class Cat extends Animal {
    private static final int MIN_ANNOYANCE_LEVEL = 1;
    private static final int MAX_ANNOYANCE_LEVEL = 10;
    int annoyanceLevel;

    public Cat(String name, String species, int annoyanceLevel) {
        super(name, species);
        setAnnoyanceLevel(annoyanceLevel);
    }

    public void setAnnoyanceLevel(int annoyanceLevel) {
        if (annoyanceLevel >= MIN_ANNOYANCE_LEVEL && annoyanceLevel <= MAX_ANNOYANCE_LEVEL) {
            this.annoyanceLevel = annoyanceLevel;
        } else {
            throw new IllegalArgumentException("Annoyance level must be between 1 and 10.");
        }
    }
}

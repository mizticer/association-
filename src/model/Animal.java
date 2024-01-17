package model;

public class Animal {
    private String name;
    private String species;
    private Trainer trainer;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getSpecies() {
        return species;
    }
}

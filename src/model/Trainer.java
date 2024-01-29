package model;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String firstName;
    private String lastName;
    private String address;
    private List<Animal> trainedAnimals;
    private List<EquipmentUsage> equipmentUsages;

    public Trainer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        trainedAnimals = new ArrayList<>();
        equipmentUsages = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if (trainedAnimals.contains(animal)) {
            throw new IllegalStateException("Trainer contain this animal");
        }
        trainedAnimals.add(animal);
        animal.setTrainer(this);
    }

    public List<Animal> getTrainedAnimals() {
        return trainedAnimals;
    }

    public void addEquipmentUsages(EquipmentUsage usage) {
        equipmentUsages.add(usage);
    }

    public List<EquipmentUsage> getEquipmentUsages() {
        return equipmentUsages;
    }


    public boolean trainedSpaniel() {
        return trainedAnimals.stream()
                .anyMatch(animal -> animal instanceof Dog && animal.getSpecies().equals("Spaniel"));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

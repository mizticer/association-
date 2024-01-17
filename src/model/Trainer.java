package model;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String firstName;
    private String lastName;
    private String address;
    private List<Animal> trainedAnimalList;
    private List<EquipmentUsage> equipmentUsages;

    public Trainer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        trainedAnimalList = new ArrayList<>();
        equipmentUsages = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        trainedAnimalList.add(animal);
        animal.setTrainer(this);
    }

    public void addEquipmentUsages(EquipmentUsage usage) {
        equipmentUsages.add(usage);
    }

    public List<EquipmentUsage> getEquipmentUsages() {
        return equipmentUsages;
    }

    public int numberOfAnimalsTrained() {
        return trainedAnimalList.size();
    }

    public boolean trainedSpaniel() {
        return trainedAnimalList.stream()
                .anyMatch(animal -> animal.getSpecies().equals("Spaniel"));
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

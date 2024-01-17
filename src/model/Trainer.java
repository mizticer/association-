package model;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    //Trenerzy (imie, nazwisko, adres) trenuja zwierzeta. Kazdy trener trenuje wiele zwierzat, ale zwierze jest pod okiem jednego trenera.
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
        this.equipmentUsages = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        trainedAnimalList.add(animal);
        animal.setTrainer(this);
    }

    public void addEquipmentUsages(EquipmentUsage usage) {
        equipmentUsages.add(usage);
    }

    public int numberOfAnimalsTrained() {
        return trainedAnimalList.size();
    }
    public boolean trainedSpaniel(){
        return trainedAnimalList.stream()
                .anyMatch(animal -> animal.getSpecies().equals("Spaniel"));
    }

}

import model.Animal;
import model.Equipment;
import model.Pterodactyl;
import model.Trainer;

import java.util.*;

public class Zoo {
    private List<Trainer> trainerList;
    private List<Animal> animalList;
    private List<Equipment> equipmentList;

    public Zoo() {
        trainerList = new ArrayList<>();
        animalList = new ArrayList<>();
        equipmentList = new ArrayList<>();
    }

    public void addTrainer(Trainer trainer) {
        trainerList.add(trainer);
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    //-znajdz trenera ktory trenował najwiecej zwierzat
    public Trainer findTrainerWithMostAnimals() {
        return trainerList.stream()
                .max(Comparator.comparingInt(Trainer::numberOfAnimalsTrained))
                .orElse(null);
    }

    //-znajdz trenerow ktorzy trenowali psy z gatunku spaniel
    public List<Trainer> findTrainerWithSpaniel() {
        return trainerList.stream()
                .filter(trainer -> trainer.trainedSpaniel())
                .toList();
    }

    //-znajdz wszystkie pterodaktyle ktore nigdy nie mialy przypisanego trenera
    public List<Pterodactyl> findPterodactylWithoutTrainer() {
        return animalList.stream()
                .filter(animal -> animal instanceof Pterodactyl)
                .filter(animal -> animal.getTrainer() == null)
                .map(animal -> (Pterodactyl) animal)
                .toList();
    }

    //-znajdz trenera ktory uzywał jakiegos sprzetu najwieksza liczbe razy
    public Trainer findTrainerWithMostEquipmentUsage(Equipment equipment) {
        Map<Trainer, Integer> trainerUsageCountMap = new HashMap<>();

        for (Trainer trainer : trainerList) {
            int usageCount = getEquipmentUsageCount(trainer, equipment);
            trainerUsageCountMap.put(trainer, usageCount);
        }

        Trainer trainerWithMostUsage = Collections.max(trainerUsageCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        return trainerWithMostUsage;
    }

    private int getEquipmentUsageCount(Trainer trainer, Equipment equipment) {
        return (int) trainer.getEquipmentUsages().stream()
                .filter(usage -> usage.getEquipment().equals(equipment))
                .count();
    }

    //-znajdz wszystkie sprzety które byly naprawiane co najmniej 2 razy*/
    public List<Equipment> findEquipmentRepairedTwiceOrMore() {
        return equipmentList.stream()
                .filter(equipment -> equipment.getRepairCount() >= 2)
                .toList();
    }
}

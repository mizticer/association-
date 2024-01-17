import model.*;

import java.util.Date;
import java.util.List;

public class Main {
    /*
		 *  W systemie przechowujemy informacje o zwierzetach (nazwa, gatunek). Dla psów przechowujemy dodatkowe ich dlugosc siersci
			oraz ulubione zabawki ,dla kotów stopien bycia wkurwiajacym futrzakiem (1-10) oraz dla pterodaktylow rozpietosc skrzydel.

			Trenerzy (imie, nazwisko, adres) trenuja zwierzeta. Kazdy trener trenuje wiele zwierzat, ale zwierze jest pod okiem jednego trenera.

			Trener uzywa Sprzetu (nazwa, stopien zuzycia(nowe, uzywane, tragiczne)), sprzet moze byc naprawiany.
			 Chcemy przechowywac informacje o tym jaki trener uzywal kiedy
			jkaiego sprzetu. Sprzet przez trenera moze byc uzywany wielokrotnie.

			-znajdz trenera ktory trenował najwiecej zwierzat
			-znajdz trenera ktory uzywał jakiegos sprzetu najwieksza liczbe razy
			-znajdz trenerow ktorzy trenowali psy z gatunku spaniel
			-znajdz wszystkie sprzety które byly naprawiane co najmniej 2 razy
			-znajdz wszystkie pterodaktyle ktore nigdy nie mialy przypisanego trenera
		 */
    public static void main(String[] args) {
        Dog dog1 = new Dog("Buddy", "Spaniel", 5, List.of("Ball", "Bone"));
        Dog dog2 = new Dog("Max", "Labrador", 7, List.of("Squeaky Toy", "Rope"));
        Cat cat1 = new Cat("Whiskers", "Persian", 8);
        Pterodactyl pterodactyl1 = new Pterodactyl("Ptero", "Pterosaur", 10.5);
        Pterodactyl pterodactyl2 = new Pterodactyl("Lambda", "Pterosaur", 11.5);

        Trainer trainer1 = new Trainer("John", "Doe", "123 Main St");
        Trainer trainer2 = new Trainer("Jane", "Smith", "456 Oak St");

        Equipment equipment1 = new Equipment("Treadmill", Condition.USED);
        Equipment equipment2 = new Equipment("Dumbbells", Condition.NEW);

        equipment1.destroy();
        equipment1.repair();
        equipment1.destroy();
        equipment1.repair();

        EquipmentUsage usage1 = new EquipmentUsage(trainer1, equipment1, new Date());
        EquipmentUsage usage2 = new EquipmentUsage(trainer1, equipment2, new Date());
        EquipmentUsage usage3 = new EquipmentUsage(trainer2, equipment1, new Date());

        Zoo zoo = new Zoo();

        zoo.addAnimal(dog1);
        zoo.addAnimal(dog2);
        zoo.addAnimal(cat1);
        zoo.addAnimal(pterodactyl1);
        zoo.addAnimal(pterodactyl2);

        zoo.addTrainer(trainer1);
        zoo.addTrainer(trainer2);

        zoo.addEquipment(equipment1);
        zoo.addEquipment(equipment2);

        trainer1.addAnimal(dog1);
        trainer1.addAnimal(dog2);
        trainer1.addAnimal(cat1);
        trainer2.addAnimal(pterodactyl1);

        trainer1.addEquipmentUsages(usage1);
        trainer1.addEquipmentUsages(usage2);
        trainer2.addEquipmentUsages(usage3);

        Trainer trainerWithMostAnimals = zoo.findTrainerWithMostAnimals();
        System.out.println("Trainer with most animals: " + trainerWithMostAnimals.getFirstName() + " " + trainerWithMostAnimals.getLastName());

        List<Trainer> trainersWithSpaniel = zoo.findTrainerWithSpaniel();
        System.out.println("Trainers who trained Spaniels: " + trainersWithSpaniel);

        List<Pterodactyl> pterodactylsWithoutTrainer = zoo.findPterodactylWithoutTrainer();
        System.out.println("Pterodactyls without a trainer: " + pterodactylsWithoutTrainer);

        Equipment mostUsedEquipment = zoo.findTrainerWithMostEquipmentUsage(equipment1).getEquipmentUsages().get(0).getEquipment();
        System.out.println("Trainer using equipment the most: " + mostUsedEquipment.getName());

        List<Equipment> equipmentRepairedTwiceOrMore = zoo.findEquipmentRepairedTwiceOrMore();
        System.out.println("Equipment repaired twice or more: " + equipmentRepairedTwiceOrMore);
    }
}
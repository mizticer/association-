import model.Animal;
import model.Trainer;

import java.util.Comparator;
import java.util.List;

public class Zoo {
    private List<Trainer> trainerList;
    private List<Animal> animalList;

    //-znajdz trenera ktory trenował najwiecej zwierzat
    public Trainer findTrainerWithMostAnimals() {
        return trainerList.stream()
                .max(Comparator.comparingInt(Trainer::numberOfAnimalsTrained))
                .orElse(null);
    }
    //-znajdz trenerow ktorzy trenowali psy z gatunku spaniel
    public List<Trainer> findTrainerWithSpaniel(){
        return trainerList.stream()
                .filter(trainer -> trainer.trainedSpaniel())
                .toList();
    }
/*


			-znajdz trenera ktory uzywał jakiegos sprzetu najwieksza liczbe razy
			-znajdz trenerow ktorzy trenowali psy z gatunku spaniel
			-znajdz wszystkie sprzety które byly naprawiane co najmniej 2 razy
			-znajdz wszystkie pterodaktyle ktore nigdy nie mialy przypisanego trenera*/

}

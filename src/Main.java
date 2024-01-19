import model.Caretaker;
import model.Child;
import model.Group;
import model.TypeCaretaker;

import javax.swing.*;
import java.util.Date;

public class Main {
    /*
     * Stwórz system do zarządzania przedszkolem. W przedszkolu mamy dzieci oraz
     * wychowawcow, dla obu chcemy znac imie, nazwisko oraz date urodzenia. Dzieci
     * dziela sie na posluszne (odznaka) i nieposluszne (przewinienia).
     *
     * Wychowawcy maja pensje (obliczana za pomoca algorytmu) i dziela sie na
     * wychowawcow kwalifikowanych (kwalifikacje) oraz tymczasowych.
     *
     * Wychowacwa odpowiada za grupe (nazwa, max liczba dzieci, obecnie 15).
     * Wychowacwca moze miec wiele grup, grupa ma jednego wychowawce.
     *
     * Kazda grupa ma przypisana sale (nazwa, kolor scian).
     *
     * -narysuj poprawny diagram uml do teog zagadnienia
     * -napisz metode która zwraca dziecko ktore ma najwiecej przewinien
     * -napisz metode ktora zwroci wychowawcow kwliafikowanych z pensja wieksza niz podany parametr
     * -zapisz do pliku imiona nazwiska wszystkich dzieci którzy sa w grupie dla wychowawcy podanego jako parametr
     * -i wyswietl wszystkie te dzieci wczytane z pliku na JLiscie
     */
    public static void main(String[] args) {
        Preschool preschool = new Preschool();

        Caretaker caretaker = new Caretaker("Agnieszka", "Wójcik", new Date(1999, 2, 24), TypeCaretaker.QUALIFIED);

        Child childOne = new Child("TestoweDziecko1", "Nazwisko1", new Date(1999, 2, 24), 2);
        Child childTwo = new Child("TestoweDziecko2", "Nazwisko2", new Date(1999, 2, 24), 5);
        Child childThree = new Child("TestoweDziecko3", "Nazwisko3", new Date(1999, 2, 24), 0);
        Child childFour = new Child("TestoweDziecko4", "Nazwisko4", new Date(1999, 2, 24), 5);
        Child childFive = new Child("TestoweDziecko5", "Nazwisko5", new Date(1999, 2, 24), 0);

        Group group = new Group("AA");
        Group group2 = new Group("BBC");

        group.addChild(childOne);
        group.addChild(childTwo);
        group.addChild(childThree);
        caretaker.addGroup(group);

        group2.addChild(childFour);
        group2.addChild(childFive);
        caretaker.addGroup(group2);

        preschool.addCaretaker(caretaker);
        preschool.addGroup(group);
        preschool.addGroup(group2);

        preschool.saveChildrenToFile(caretaker);

        SwingUtilities.invokeLater(() -> {
            ChildListGUI gui = new ChildListGUI();
            gui.setVisible(true);
        });
    }
}

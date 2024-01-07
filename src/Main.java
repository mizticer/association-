import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
     * Klient kupuje produkty. Klient ma imie nazwisko i rozmiar penisa. Pordukt ma nazwe, cene i jesli jest to kondom to wymiar.
     *  Klient moze miec wiele produktow, produkt moze miec jednego klienta.
     *
     *  1) Napisz mrtode ktota znajduje klienta ktory wydal najwiecej.
     *
     *   2) napisz metode ktora zwroci liste klientow ktorzy kupili durexa
     *
     *   3) napisz metode ktora zwroci liste klientow ktorzy kupili durexy ale nie na swoj rozmiar 😃
     */

    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Client> cLientList = new ArrayList<>();

        Client clientOne = new Client("Michal", "Kowalski", SizeCondom.XL);
        Client clientTwo = new Client("Marcel", "Lewczuk", SizeCondom.S);
        Client clientThree = new Client("Marian", "Dzieciol", SizeCondom.M);
        Client clientFour = new Client("Wojciech", "Suchodolski", SizeCondom.L);
        Client clientFive = new Client("Kacper", "Lebioda", SizeCondom.L);

        Product productDurexS = new Condom("Durex", 10.0, SizeCondom.S);
        Product productDurexM = new Condom("Durex", 12.0, SizeCondom.M);
        Product productDurexL = new Condom("Durex", 15.0, SizeCondom.L);
        Product productDurexXL = new Condom("Durex", 20.0, SizeCondom.XL);
        Product productCondomXL = new Condom("Condom", 8.0, SizeCondom.L);
        Product productBread = new Product("Bread", 20.0);
        Product productButter = new Product("Butter", 30.0);
        Product productCornflakes = new Product("Cornflakes", 40.0);

        clientOne.addProduct(productDurexXL);
        clientOne.addProduct(productButter);
        clientOne.addProduct(productCornflakes);
        clientOne.addProduct(productBread);

        clientTwo.addProduct(productDurexXL);
        clientTwo.addProduct(productButter);

        clientThree.addProduct(productDurexM);
        clientThree.addProduct(productBread);

        clientFour.addProduct(productDurexM);
        clientFour.addProduct(productBread);

        clientFive.addProduct(productCondomXL);
        clientFive.addProduct(productButter);

        cLientList.add(clientOne);
        cLientList.add(clientTwo);
        cLientList.add(clientThree);
        cLientList.add(clientFour);
        cLientList.add(clientFive);
        shop.setClientList(cLientList);
        System.out.println("The customer with the largest expenditure: " + shop.findExpensiveReceipt().toString());
        System.out.println("Customers buying Durex: " + shop.clientListWithDurex().toString());
        System.out.println("Customers buying Durex but not in their size: " + shop.wrongSizeDurexSearch().toString());
    }
}
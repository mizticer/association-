import model.*;

import java.util.Date;

public class Main {
    /*
Napisz krótki program do zarządzania sklepem internetowym.
W sklepie pracuje obsługa(imie, nazwisko, adres, data rozpoczęcia pracy). Osoby z obsługi mogą zostać managerami.
Sklep może zarejestrować nowego klienta(imie, nazwisko, adres, data rejestracji). Klient może mieć wiele koszyków,
 	które mogą przechowywać wiele produktów(nazwa, cena).
W sklepie powinna być możliwość dokonania zakupu, co usuwa koszyk klientowi,
 	ale umieszcza jego odpowiednik w "historii zamówień".
*/
    public static void main(String[] args) {
        Store store = new Store();

        Employee employee1 = new Employee("John", "Doe", "123 Main St", new Date(), EmployeeType.SERVICE);
        Employee employee2 = new Employee("Jane", "Smith", "456 Oak St", new Date(), EmployeeType.SERVICE);

        Client client1 = new Client("Alice", "Johnson", "789 Elm St");
        Client client2 = new Client("Bob", "Williams", "101 Pine St");

        store.hireEmployee(employee1);
        store.hireEmployee(employee2);

        employee1.promoteToManager();

        store.registerClient(client1);
        store.registerClient(client2);

        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);

        Basket basket1 = new Basket();
        Basket basket2 = new Basket();

        basket1.addProduct(product1);
        basket2.addProduct(product2);

        client1.addBasket(basket1);
        client2.addBasket(basket2);

        try {
            store.makePurchase(client1, basket1);
            System.out.println("Purchase successful for client1");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        try {
            store.makePurchase(client2, basket1);
            System.out.println("Purchase successful for client2");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
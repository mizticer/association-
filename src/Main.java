import model.Car;
import model.Client;
import model.Employee;
import model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /*
		 * Stwórz klasę Pracownik (imie,nazwisko, adres, pensja i Klient (imie,nazwisko, ulubiony produkt). Klient kupuje produkty (nazwa, cena).
			Pracownik uzywa samochod (model, marka)

			1) Znajdz klienta który wydal najwiecej

			2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)

			3) Wyswietl 3 top pracownikow z najwieksza pensja

			4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta
		 */
    public static void main(String[] args) {
        Client clientOne = new Client("Michal", "Wojciechowski");
        Client clientTwo = new Client("Jan", "Smith");
        Client clientThree = new Client("Helena", "Doe");


        clientOne.buyProduct(new Product("Chocolate", 7.0));
        clientOne.buyProduct(new Product("Chocolate", 7.0));
        clientOne.buyProduct(new Product("Chocolate", 7.0));

        clientTwo.buyProduct(new Product("Ice cream", 2.0));
        clientTwo.buyProduct(new Product("Ice cream", 2.0));

        clientThree.buyProduct(new Product("Banana", 1.0));

        Car car1 = new Car("Toyota", "Camry");
        Car car2 = new Car("Ford", "Mustang");
        Car car3 = new Car("Honda", "Civic");
        Car car4 = new Car("Chevrolet", "Impala");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Doe", "Brakadresu", 5000.0));
        employees.add(new Employee("Jane", "Smith", "Brakadresu", 5500.0));
        employees.add(new Employee("Bob", "Johnson", "Brakadresu", 4800.0));
        employees.add(new Employee("Alice", "Williams", "Brakadresu", 6000.0));
        employees.add(new Employee("Michael", "Brown", "Brakadresu", 5200.0));
        employees.add(new Employee("Emily", "Davis", "Brakadresu", 5300.0));

        employees.get(0).rentCar(car1);
        employees.get(0).rentCar(car1);
        employees.get(0).rentCar(car1);
        employees.get(1).rentCar(car2);
        employees.get(1).rentCar(car3);
        employees.get(1).rentCar(car4);
        employees.get(2).rentCar(car1);
        employees.get(2).rentCar(car1);
        employees.get(2).rentCar(car2);
        employees.get(2).rentCar(car2);
        employees.get(2).rentCar(car2);

        Client searchedCLient = findClientWithMostExpensiveListProduct(Arrays.asList(clientOne, clientTwo, clientThree));
        System.out.println("Client who spent the most money: " + searchedCLient.getFirstName() + " " + searchedCLient.getLastName());
        System.out.println("Favourite products client");
        printFavourtieProductOfClient(clientOne, clientTwo, clientThree);
        System.out.println("Top earns from employee");
        findTopEmployee(employees);
        System.out.println("Count rent car for all employees");
        employees.forEach(Employee::countRentCar);

    }

    private static void printFavourtieProductOfClient(Client... clients) {
        for (Client client : clients) {
            System.out.println(client.getFirstName() + " " + client.getLastName() + " have favourite product - " + client.findFavouriteProduct());
        }
    }

    private static Client findClientWithMostExpensiveListProduct(List<Client> clientList) {
        if (clientList.isEmpty()) {
            throw new IllegalStateException();
        }
        Client clientWithMaxExpenses = clientList.get(0);
        for (Client client : clientList) {
            if (client.getExpenses() > clientWithMaxExpenses.getExpenses()) {
                clientWithMaxExpenses = client;
            }
        }
        return clientWithMaxExpenses;
    }

    private static void findTopEmployee(List<Employee> employeeList) {
        List<Employee> topEmployeesEarnes = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        topEmployeesEarnes.forEach(employee ->
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getSalary()));
    }

}

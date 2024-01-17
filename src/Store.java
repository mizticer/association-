import model.Basket;
import model.Client;
import model.Employee;
import model.OrderHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store {
    private List<Employee> employeeList;
    private List<Client> registeredClients;
    private List<OrderHistory> orderHistories;

    public Store() {
        employeeList = new ArrayList<>();
        registeredClients = new ArrayList<>();
        orderHistories = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void registerClient(Client client) {
        registeredClients.add(client);
        client.setRegistrationDate(new Date());
    }

    public void makePurchase(Client client, Basket basket) {
        if (client.getBasketList().contains(basket)) {
            OrderHistory order = new OrderHistory(client, basket, new Date());
            orderHistories.add(order);
            client.removeBasketFromList(basket);
        } else {
            throw new IllegalStateException("Client dont have this basket");
        }
    }

    public List<OrderHistory> getOrderHistories() {
        return orderHistories;
    }
}

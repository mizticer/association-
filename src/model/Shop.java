package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shop {
    private List<Client> clientList;

    public Shop() {
        clientList = new ArrayList<>();
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public Client findExpensiveReceipt() {
        Map<Client, Double> mapWithExpenses = new HashMap<>();
        Client clientWithBiggestExpenses = null;
        double maxExpenses = 0;

        for (Client client : clientList) {
            double expenses = 0.0;
            for (Product product : client.getProductList()) {
                expenses += product.getCost();
            }
            mapWithExpenses.put(client, expenses);
        }
        for (Map.Entry<Client, Double> entrySet : mapWithExpenses.entrySet()) {
            if (entrySet.getValue() > maxExpenses) {
                maxExpenses = entrySet.getValue();
                clientWithBiggestExpenses = entrySet.getKey();
            }
        }
        return clientWithBiggestExpenses;
    }

    public List<Client> clientListWithDurex() {
        return clientList.stream()
                .filter(client -> client.getProductList().stream().anyMatch(product -> product.getName().equalsIgnoreCase("Durex")))
                .collect(Collectors.toList());
    }

    public List<Client> wrongSizeDurexSearch() {
        List<Client> clientWithDurex = clientListWithDurex();
        return clientWithDurex.stream()
                .filter(client -> client.getProductList().stream()
                        .anyMatch(product -> product instanceof Condom && !isCorrectSize((Condom) product, client.getSizePenis())))
                .collect(Collectors.toList());
    }

    boolean isCorrectSize(Condom condom, SizeCondom clientSize) {
        return condom.getSizeCondom().equals(clientSize);
    }
}

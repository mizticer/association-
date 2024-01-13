package model;

import java.util.ArrayList;
import java.util.List;
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

//        Map<Client, Double> mapWithExpenses = new HashMap<>();
//        Client clientWithBiggestExpenses = null;
//        double maxExpenses = 0;
//
//        for (Client client : clientList) {
//            mapWithExpenses.put(client, client.getExpenses());
//        }
//        for (Map.Entry<Client, Double> entrySet : mapWithExpenses.entrySet()) {
//            if (entrySet.getValue() > maxExpenses) {
//                maxExpenses = entrySet.getValue();
//                clientWithBiggestExpenses = entrySet.getKey();
//            }
//        }
//        return clientWithBiggestExpenses;
    }

    public List<Client> clientListWithDurex() {
        return clientList.stream()
                .filter(Client::boughtCondom)
                .toList();
    }

    public List<Client> wrongSizeDurexSearch() {
        return clientList.stream()
                .filter(Client::boughtWrongSizeCondom)
                .toList();
    }

}

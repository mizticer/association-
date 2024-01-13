package model;

public class Product {
    private String name;
    private double cost;
    private Client client;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client cLient) {
        this.client = cLient;
    }

}

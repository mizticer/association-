package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private CondomSize penisSize;
    private List<Product> productList;

    public Client(String firstName, String lastName, CondomSize penisSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.penisSize = penisSize;
        productList = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (product.getClient() != null) {
            throw new IllegalStateException();
        }
        productList.add(product);
        product.setClient(this);
    }

    public double getExpenses() {
        double sum = 0.0;
        for (Product product : productList) {
            sum += product.getCost();
        }
        return sum;
    }

    public boolean boughtCondom() {
        return productList.stream()
                .anyMatch(product -> product instanceof Condom && product.getName().equalsIgnoreCase("Durex"));
    }

    public boolean boughtWrongSizeCondom() {
        return productList.stream()
                .anyMatch(product -> product instanceof Condom && ((Condom) product).getSize() != penisSize);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public CondomSize getPenisSize() {
        return penisSize;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

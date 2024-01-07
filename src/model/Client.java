package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private SizeCondom sizePenis;
    private List<Product> productList;

    public Client(String firstName, String lastName, SizeCondom sizeCondom) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sizePenis = sizeCondom;
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public SizeCondom getSizePenis() {
        return sizePenis;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

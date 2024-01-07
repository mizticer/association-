package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Client {
    private String firstName;
    private String lastName;
    private Product favouriteProduct;
    private List<Product> productList;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productList = new ArrayList<>();
    }

    public Product getFavouriteProduct() {
        return favouriteProduct;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void buyProducts(List<Product> productList) {
        this.productList.addAll(productList);
        Map<Product, Long> countMap = productList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Product favouriteProduct = countMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        this.favouriteProduct = favouriteProduct;
    }

}

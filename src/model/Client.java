package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    private String firstName;
    private String lastName;
    private String favouriteProduct;
    private List<Product> productList;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productList = new ArrayList<>();
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

    public double getExpenses() {
        double sum = 0.0;
        for (Product product : productList) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void buyProduct(Product product) {
        if (product.getClient() != null) {
            throw new IllegalStateException();
        }
        productList.add(product);
        product.setClient(this);
    }

    public String findFavouriteProduct() {
        if (productList.isEmpty()) {
            throw new IllegalStateException();
        }

        Map<String, Integer> productCounts = new HashMap<>();

        for (Product product : productList) {
            String productName = product.getName();
            productCounts.put(productName, productCounts.getOrDefault(productName, 0) + 1);
        }

        String mostCommonProduct = null;
        int maxOccurrences = 0;

        for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
            if (entry.getValue() > maxOccurrences) {
                mostCommonProduct = entry.getKey();
                maxOccurrences = entry.getValue();
            }
        }

        if (mostCommonProduct != null) {
            favouriteProduct = mostCommonProduct;
        } else {
            favouriteProduct = "nothing";
        }
        return favouriteProduct;
    }

}

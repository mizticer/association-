package model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> productList;
    private Client client;

    public Basket() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
        product.setBasket(this);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "productList=" + productList +
                ", client=" + client +
                '}';
    }
}

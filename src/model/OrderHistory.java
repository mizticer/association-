package model;

import java.util.Date;

public class OrderHistory {
    private Client client;
    private Basket basket;
    private Date purchaseDate;

    public OrderHistory(Client client, Basket basket, Date purchaseDate) {
        this.client = client;
        this.basket = basket;
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "client=" + client +
                ", basket=" + basket +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}

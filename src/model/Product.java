package model;

public class Product {
    private String name;
    private double price;
    private Basket basket;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", basket=" + basket +
                '}';
    }
}

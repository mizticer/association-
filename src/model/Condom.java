package model;

public class Condom extends Product {
    private CondomSize size;

    public Condom(String name, double cost, CondomSize size) {
        super(name, cost);
        this.size = size;
    }

    public CondomSize getSize() {
        return size;
    }
}

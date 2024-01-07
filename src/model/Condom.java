package model;

public class Condom extends Product {
    private SizeCondom sizeCondom;

    public Condom(String name, double cost, SizeCondom sizeCondom) {
        super(name, cost);
        this.sizeCondom = sizeCondom;
    }

    public SizeCondom getSizeCondom() {
        return sizeCondom;
    }
}

package model;

public class Pterodactyl extends Animal {
    private double wingspan;
    public Pterodactyl(String name, String species, double wingspan) {
        super(name, species);
        this.wingspan = wingspan;
    }
}

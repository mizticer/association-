package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends Person {
    private Date registrationDate;
    private List<Basket> basketList;

    public Client(String firstName, String lastName, String address) {
        super(firstName, lastName, address);
        basketList = new ArrayList<>();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void addBasket(Basket basket) {
        basketList.add(basket);
        basket.setClient(this);
    }

    public List<Basket> getBasketList() {
        return basketList;
    }

    public void removeBasketFromList(Basket basket) {
        if (basketList.contains(basket)) {
            basketList.remove(basket);
        } else {
            throw new IllegalStateException("Basket does not exist in client's basket list");
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "registrationDate=" + registrationDate +
                ", basketList=" + basketList +
                '}';
    }
}

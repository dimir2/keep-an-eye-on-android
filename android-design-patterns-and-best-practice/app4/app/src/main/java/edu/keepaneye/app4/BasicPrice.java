package edu.keepaneye.app4;

public class BasicPrice {
    private static BasicPrice basicPrice = new BasicPrice();
    private float price;

    private BasicPrice() {

    }

    public static BasicPrice getInstance() {
        return basicPrice;
    }

    protected float getPrice() {
        return price;
    }

    protected void setPrice(float price) {
        this.price = price;
    }
}

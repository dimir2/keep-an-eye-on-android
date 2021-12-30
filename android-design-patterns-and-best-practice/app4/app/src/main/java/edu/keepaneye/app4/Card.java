package edu.keepaneye.app4;

public class Card implements Strategy {
    @Override
    public String processPayment(float price) {
        return String.format("%.2f", price + 0.25f);
    }
}

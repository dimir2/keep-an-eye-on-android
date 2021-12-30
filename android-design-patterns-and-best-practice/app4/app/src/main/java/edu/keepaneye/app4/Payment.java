package edu.keepaneye.app4;

public class Payment {

    //Provides context for strategies

    private Strategy strategy;

    public Payment(Strategy strategy) {
        this.strategy = strategy;
    }

    public String employStrategy(float price) {
        return strategy.processPayment(price);
    }
}

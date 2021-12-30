package edu.keepaneye.app3;

public class Bagel extends Bread {
    @Override
    public String name() {
        return "Bagel";
    }
    @Override
    public int calories() {
        return 250;
    }
}

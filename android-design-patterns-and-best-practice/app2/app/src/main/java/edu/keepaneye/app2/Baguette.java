package edu.keepaneye.app2;

public class Baguette implements Bread {
    @Override
    public String name() {
        return "Baguette";
    }

    @Override
    public String calories() {
        return ": 65 kcal";
    }

    @Override
    public String toString() {
        return "bread: " + name() + " calories" + calories();
    }
}

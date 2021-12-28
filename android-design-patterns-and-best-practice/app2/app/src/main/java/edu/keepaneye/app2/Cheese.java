package edu.keepaneye.app2;

public class Cheese implements Filling {
    @Override
    public String name() {
        return "Cheese";
    }

    @Override
    public String calories() {
        return ": 105 kcal";
    }

    @Override
    public String toString() {
        return "filling: " + name() + " calories" + calories();
    }
}
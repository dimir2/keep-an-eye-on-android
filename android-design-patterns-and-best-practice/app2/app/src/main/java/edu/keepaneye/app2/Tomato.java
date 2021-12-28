package edu.keepaneye.app2;

public class Tomato implements Filling {
    @Override
    public String name() {
        return "Tomato";
    }

    @Override
    public String calories() {
        return ": 95 kcal";
    }

    @Override
    public String toString() {
        return "filling: " + name() + " calories" + calories();
    }
}
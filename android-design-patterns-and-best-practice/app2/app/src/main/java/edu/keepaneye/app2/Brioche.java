package edu.keepaneye.app2;

public class Brioche implements Bread {
    @Override
    public String name() {
        return "Brioche";
    }

    @Override
    public String calories() {
        return ": 75 kcal";
    }

    @Override
    public String toString() {
        return "bread: " + name() + " calories" + calories();
    }
}
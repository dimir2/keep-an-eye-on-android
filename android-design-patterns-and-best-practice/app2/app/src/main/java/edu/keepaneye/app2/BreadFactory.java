package edu.keepaneye.app2;

public class BreadFactory extends AbstractFactory {
    public Bread getBread(String bread) {
        if (bread == "BAG") {
            return new Baguette();
        } else if (bread == "BRI") {
            return new Brioche();
        }
        return null;
    }

    @Override
    Filling getFilling(String filling) {
        return null;
    }
}

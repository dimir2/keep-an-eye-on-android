package edu.keepaneye.app2;

public class FillingFactory extends AbstractFactory {
    public Bread getBread(String bread) {
        return null;
    }

    @Override
    Filling getFilling(String filling) {
        if (filling == "CHE") {
            return new Cheese();
        } else if (filling == "TOM") {
            return new Tomato();
        }
        return null;
    }
}

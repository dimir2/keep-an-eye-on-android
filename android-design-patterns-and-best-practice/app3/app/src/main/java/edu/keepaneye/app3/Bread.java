package edu.keepaneye.app3;

public abstract class Bread implements Ingredient {
    @Override
    public abstract String name();

    @Override
    public abstract int calories();
}

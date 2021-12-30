package edu.keepaneye.app3;

public abstract class Filling implements Ingredient{
    @Override
    public abstract String name();

    @Override
    public abstract int calories();
}

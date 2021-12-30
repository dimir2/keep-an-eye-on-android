package edu.keepaneye.app3;

public class SandwichBuilder {

    public static Sandwich readyMade() {
        Sandwich sandwich = new Sandwich();

        sandwich.addIngredient(new Bagel());
        sandwich.addIngredient(new SmokedSalmon());
        sandwich.addIngredient(new CreamCheese());

        return sandwich;
    }

    public static Sandwich build(Sandwich s, Ingredient i) {
        s.addIngredient(i);
        return s;
    }
}

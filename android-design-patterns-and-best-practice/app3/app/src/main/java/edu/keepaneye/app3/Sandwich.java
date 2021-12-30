package edu.keepaneye.app3;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    public static final String TAG = "tag";
    private List<Ingredient> ingredients = new ArrayList<>();

    public void getCalories() {
        int c = 0;
        for (Ingredient i : ingredients) {
            c += i.calories();
        }
        Log.d(TAG, "Total calories : " + c + " kcal");
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void getSandwich() {
        for (Ingredient i : ingredients) {
            Log.d(TAG, i.name() + " : " + i.calories() + " kcal");
        }
    }
}
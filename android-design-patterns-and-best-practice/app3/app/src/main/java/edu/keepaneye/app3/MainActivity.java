package edu.keepaneye.app3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SandwichBuilder b = new SandwichBuilder();
        Sandwich customSandwich = new Sandwich();
        customSandwich = b.build(customSandwich, new Bun());
        customSandwich = b.build(customSandwich, new CheddarCheese());

        Log.d(TAG, "Custom sandwich : ");
        customSandwich.getSandwich();
        customSandwich.getCalories();

        Sandwich offTheShelf = SandwichBuilder.readyMade();
        Log.d(TAG, "Ready made sandwich : ");
        offTheShelf.getSandwich();
        offTheShelf.getCalories();
    }
}
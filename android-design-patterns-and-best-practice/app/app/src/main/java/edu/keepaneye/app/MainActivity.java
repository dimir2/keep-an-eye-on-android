package edu.keepaneye.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView =findViewById(R.id.text_view);

        BreadFactory breadFactory = new BreadFactory();
        Bread bread = breadFactory.getBread("BAG");

        textView.setText(new StringBuilder().append(bread.name()).toString());

        Log.v(DEBUG_TAG, "onCreate: " + bread);
    }
}
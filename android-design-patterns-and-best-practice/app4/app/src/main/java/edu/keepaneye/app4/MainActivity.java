package edu.keepaneye.app4;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public BasicPrice basicPrice = BasicPrice.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton btnCash = findViewById(R.id.cash_btn);
        AppCompatButton btnCard = findViewById(R.id.card_btn);
        AppCompatButton btnCoupon = findViewById(R.id.coupon_btn);
        btnCash.setOnClickListener(this::onClick);
        btnCard.setOnClickListener(this::onClick);
        btnCoupon.setOnClickListener(this::onClick);

        basicPrice.setPrice(1.5f);
    }

    @Override
    public void onClick(View view) {
        Payment payment;
        switch (view.getId()) {
            case R.id.card_btn:
                payment = new Payment(new Card());
                break;
            case R.id.coupon_btn:
                payment = new Payment(new Coupon());
                break;
            default:
                payment = new Payment(new Cash());
                break;
        }

        AppCompatTextView textView = findViewById(R.id.price);

        String price = new StringBuilder()
                .append("Total cost : $")
                .append(payment.employStrategy(basicPrice.getPrice()))
                .append("c")
                .toString();

        textView.setText(price);
    }
}
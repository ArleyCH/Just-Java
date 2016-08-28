package com.example.user.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
    TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        priceTextView = (TextView) findViewById(R.id.price_text_view);

        display(0);
        displayPrice(0);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = Integer.parseInt(quantityTextView.getText().toString());
        displayPrice(price*5);
    }
    /**
     * This method increases the quantity by 1.
     */
    public void increment(View view) {
        int newIncrement = Integer.parseInt(quantityTextView.getText().toString());
        display(newIncrement+1);
    }
    /**
     * This method decreases the quantity by 1.
     */
    public void decrement(View view) {
        int newDecrement = Integer.parseInt(quantityTextView.getText().toString());
        display(newDecrement-1);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        priceTextView.setText("Total: "+NumberFormat.getCurrencyInstance().format(number) + "\nThanks!!!!");

    }
}

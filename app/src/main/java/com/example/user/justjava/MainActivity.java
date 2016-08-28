package com.example.user.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
    TextView priceTextView;
    String whippedCreamString;
    CheckBox whippedCreamCheckBox;
    String chocolate;
    CheckBox chocholateCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        priceTextView = (TextView) findViewById(R.id.price_text_view);
        whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        chocholateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);

        chocolate="";
        whippedCreamString="";

        display(0);
        displayPrice(0,whippedCreamString,chocolate);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitSummary(View view) {
        int price = Integer.parseInt(quantityTextView.getText().toString());
        displayPrice(price*5,whippedCreamString,chocolate);
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
     * This method evaluates the state of the Whipped cream checkbox
     */
    public void  handleWhippedCream(View view){
        boolean checked =whippedCreamCheckBox.isChecked();
        if(checked){
            whippedCreamString="\nWith whipped cream!!!!";
        }else{
            whippedCreamString="";
        }
    }

    /**
     * This method evaluates the state of the chocolate checkbox
     */
    public void  handleChocolate(View view){
        boolean checked =chocholateCheckBox.isChecked();
        if(checked){
            chocolate="\nWith chocolate!!!!";
        }else{
            chocolate="";
        }
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
    private void displayPrice(int number,String cream,String choco){
        priceTextView.setText("Name: Arley Chaves\nTotal: "+NumberFormat.getCurrencyInstance().format(number) + "\nThanks!!!!"
                +cream+choco);
        //if(boolCream){
        //    //priceTextView.setText(priceTextView.getText().toString()+ "\nWith Whipped Cream!!!");
        //}
    }
}

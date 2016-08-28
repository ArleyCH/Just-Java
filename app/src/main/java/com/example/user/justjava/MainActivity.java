package com.example.user.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
//    TextView priceTextView;
    String whippedCreamString;
    CheckBox whippedCreamCheckBox;
    String chocolate;
    CheckBox chocholateCheckBox;
    EditText nameEditText;
    int taste;  // 1=Whipped cream 2=Chocolate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//        priceTextView = (TextView) findViewById(R.id.price_text_view);
        whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        chocholateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        nameEditText = (EditText) findViewById(R.id.edit_text_name);

        taste=0;
        chocolate="";
        whippedCreamString="";

        chocholateCheckBox.setChecked(false);
        whippedCreamCheckBox.setChecked(false);

        display(0);
        displayPrice(0,whippedCreamString,chocolate);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitSummary(View view) {
        int coffees = Integer.parseInt(quantityTextView.getText().toString());
        int price = 0;
        price=taste;
        if(taste==0){
            Toast.makeText(getApplicationContext(),"Pick a flavor!!!!",Toast.LENGTH_LONG).show();
        }
        /*
         $5 base coffee price + $1 if whipped cream or + $2 if chocolate, times the amount of coffees
         */
        displayPrice((5+price)*coffees,whippedCreamString,chocolate);
    }
    /**
     * This method increases the quantity by 1.
     */
    public void increment(View view) {
        int newIncrement = Integer.parseInt(quantityTextView.getText().toString());
        if(newIncrement==100){
            Toast.makeText(getApplicationContext(),"We just have 100 cups!!!",Toast.LENGTH_LONG).show();
        }else{
            newIncrement++;
        }
        display(newIncrement);
    }
    /**
     * This method decreases the quantity by 1.
     */
    public void decrement(View view) {
        int newDecrement = Integer.parseInt(quantityTextView.getText().toString());
        if(newDecrement==0){
            Toast.makeText(getApplicationContext(),"Please drink something :(",Toast.LENGTH_LONG).show();
        }else{
            newDecrement--;
        }
        display(newDecrement);
    }

    /**
     * This method evaluates the state of the Whipped cream checkbox
     */
    public void  handleWhippedCream(View view){ //one dollar with cream
        boolean checked =whippedCreamCheckBox.isChecked();
        if(checked){
            chocholateCheckBox.setChecked(false);
            whippedCreamString="\nWith whipped cream!!!!";
            chocolate="";
            taste=1;
        }else{
            whippedCreamString="";
        }
    }

    /**
     * This method evaluates the state of the chocolate checkbox
     */
    public void  handleChocolate(View view){ //Two dollars with chocolate
        boolean checked =chocholateCheckBox.isChecked();
        if(checked){
            whippedCreamCheckBox.setChecked(false);
            chocolate="\nWith chocolate!!!!";
            whippedCreamString="";
            taste=2;
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
        String name = nameEditText.getText().toString();
        //priceTextView.setText("Name: "+name+"\nTotal: "+NumberFormat.getCurrencyInstance().format(number)+cream+choco+"\nThanks!!!!");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order");
        intent.putExtra(Intent.EXTRA_TEXT, "Name: "+name+"\nTotal: "+NumberFormat.getCurrencyInstance().format(number)+cream+choco+"\nThanks!!!!");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

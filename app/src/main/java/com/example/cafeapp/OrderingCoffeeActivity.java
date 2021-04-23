package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.cafeapp.MainActivity.customerOrder;
import static com.example.cafeapp.MenuItem.doubleToDollar;

/**
 * @Author Matthew Schilling and Gordon Miller
 * The coffee activity class allows a user to select what type of coffee they would like then
 * creates a coffee object based on that selection
 */
public class OrderingCoffeeActivity extends AppCompatActivity {
    private String coffeeSize = "Short";
    private String addIns = "|";
    private int numAddIns;
    private int orderNum = 100;
    private double subtotal;
    private double sizeCost;
    private double addInCost;
    private final static double SHORTCOST = 1.99;
    private final static double TALLCOST = 2.49;
    private final static double GRANDECOST = 2.99;
    private final static double VENTICOST = 3.49;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
    }

    /**
     * The add coffee method creates a coffee object and adds it to the order list once the user
     * finalizes their choices
     * @param view
     */
    public void addCoffee(View view){
        //coffeeSize = ((RadioButton) view).getText().toString();
        CheckBox cream = (CheckBox) findViewById(R.id.creamBox);
        if(cream.isChecked()){
            addIns += " cream |";
            numAddIns ++;
        }
        CheckBox syrup = (CheckBox) findViewById(R.id.syrupBox);
        if(syrup.isChecked()){
            addIns += " syrup |";
            numAddIns ++;
        }
        CheckBox milk = (CheckBox) findViewById(R.id.milkBox);
        if(milk.isChecked()){
            addIns += " milk |";
            numAddIns ++;
        }
        CheckBox caramel = (CheckBox) findViewById(R.id.caramelBox);
        if(caramel.isChecked()){
            addIns += " caramel |";
            numAddIns ++;
        }
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCreamBox);
        if(whippedCream.isChecked()){
            addIns += " whippedCream |";
            numAddIns ++;
        }
        Coffee tempCoffee = new Coffee(coffeeSize, numAddIns, addIns);
        Order coffeeOrder = new Order(orderNum);
        coffeeOrder.add(tempCoffee);
        customerOrder.add(coffeeOrder);
        Toast.makeText(getApplicationContext(),coffeeSize + " coffee with " +
                addIns +" added to order", Toast.LENGTH_LONG).show();
        finish();
    }

    /**
     * This method will listen for selections of coffee size and update the subtotal
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            coffeeSize = ((RadioButton) view).getText().toString();
            switch (coffeeSize){
                case "Tall":
                    sizeCost = TALLCOST;
                    break;
                case "Short":
                    sizeCost = SHORTCOST;
                    break;
                case "Grande":
                    sizeCost = GRANDECOST;
                    break;
                case "Venti":
                    sizeCost = VENTICOST;
                    break;
            }

            final TextView setCoffeePrice = (TextView) findViewById(R.id.subtotal);
            subtotal = 0.0;
            subtotal += sizeCost;
            String temp = doubleToDollar(subtotal);
            setCoffeePrice.setText(temp);
            //Toast.makeText(getApplicationContext(),coffeeSize, Toast.LENGTH_SHORT).show();
        }
        }

    /**
     * This method will listen for a checkbox being clicked and update the total cost for addins
     * @param view
     */
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        final TextView setSubtotal = (TextView) findViewById(R.id.subtotal);

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.creamBox:
            case R.id.milkBox:
            case R.id.whippedCreamBox:
            case R.id.caramelBox:
            case R.id.syrupBox:
                if (checked)
                    addInCost += 0.2;
                else
                    if(addInCost>=0.2) {
                        addInCost -= 0.2;
                }
                break;
            default:
                //setSubtotal.setText((Double.toString(subtotal)));

        }
        subtotal += addInCost;
        String temp = doubleToDollar(subtotal);
        setSubtotal.setText(temp);
    }

}
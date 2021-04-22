package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.cafeapp.MainActivity.customerOrder;

public class CoffeeActivity extends AppCompatActivity {
    private String coffeeSize = "short";
    private String addIns;
    private int numAddIns;
    private int orderNum = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
    }
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
        Coffee tempCoffee = new Coffee(coffeeSize, numAddIns);
        Order coffeeOrder = new Order(orderNum);
        coffeeOrder.add(tempCoffee);
        customerOrder.add(coffeeOrder);
        Toast.makeText(getApplicationContext(),coffeeSize + " coffee with " +
                addIns +" added to order", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            coffeeSize = ((RadioButton) view).getText().toString();
            Toast.makeText(getApplicationContext(),coffeeSize, Toast.LENGTH_SHORT).show();
        }
        }

}
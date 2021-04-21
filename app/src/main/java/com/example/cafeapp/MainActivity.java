package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.cafeapp.DonutActivity.DONUT_ORDER_KEY;

public class MainActivity extends AppCompatActivity {

    public static final int DONUT_ORDER = 1;
    public static final int COFFEE_ORDER = 2;
    //public static final String DONUT_KEY =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method will display the donut ordering screen and enable return of information
     * @param view the donut screen object
     */
    public void startDonutOrder(View view){
        Intent intent = new Intent(this, DonutActivity.class);
        startActivityForResult(intent, DONUT_ORDER);
    }

    /**
     * This method will display the coffee ordering screen and enable return of information
     * @param view the coffee screen object
     */
    public void startCoffeeOrder(View view){
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivityForResult(intent, COFFEE_ORDER);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == DONUT_ORDER){
            if(resultCode == RESULT_OK){
                //this needs to be changed to accept serializable objects and add the donut order to the list of orders.
                String result = data.getStringExtra(DONUT_ORDER_KEY);
                System.out.println(result);

            }
        }
    }
}
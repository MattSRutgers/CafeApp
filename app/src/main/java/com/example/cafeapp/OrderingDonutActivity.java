package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.cafeapp.MainActivity.DONUT_ORDER;
import static com.example.cafeapp.MainActivity.customerOrder;

/**
 * @Authors Matthew Schilling and Gordon Miller
 * The donut activity class handles ordering of donuts for the cafe app.
 */
public class OrderingDonutActivity extends AppCompatActivity {
    public static final String DONUT_ORDER_KEY = "com.example.cafeapp.DONUTKEY";
    private ArrayList<Donut> curOrder = new ArrayList<>();
    private ArrayList<Order> donutOrder = new ArrayList<>();
    private int orderNumber = 1;
    private static  final double DONUT_PRICE = 1.39;
    private double subtotalDisplay;

    /**
     * This method initializes the spinner objects with their values when creating
     * the view for donut ordering.
     * @param savedInstanceState the object to create from
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        //getIntent();

        //create the donut flavor spinner and populate
        Spinner spinner = (Spinner) findViewById(R.id.donutSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.donutArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //create the donut quantity spinner and populate
        Spinner counter = (Spinner) findViewById(R.id.donutQuantitySpinner);
        ArrayAdapter<CharSequence> countAdapter = ArrayAdapter.createFromResource(this,
                R.array.count, android.R.layout.simple_spinner_item);
        countAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        counter.setAdapter(countAdapter);
    }

    /**
     * The placeDonutOrder method will add the donut order object to the intent then pass
     * it back to the main activity using set result
     * @param view the donut ordering screen
     */
    public void placeDonutOrder(View view){
        Order addingOrder = approveOrder();
        //Intent intent = new Intent(this, Donut.class);
        //intent.putExtra(DONUT_ORDER,donutOrder);
        customerOrder.add(addingOrder);
        //setResult(Activity.RESULT_OK,intent);
        //finish();
    }

    /**
     * The addDonut method adds donut objects to an arraylist of donuts
     * @param view the donut ordering view
     */
    public void addDonut(View view){
        Spinner flavorSpinner = (Spinner) findViewById(R.id.donutSpinner);
        String flavor = flavorSpinner.getSelectedItem().toString();
        Spinner countSpinner = (Spinner) findViewById(R.id.donutQuantitySpinner);
        int count = countSpinner.getSelectedItemPosition() + 1 ;
        //Toast.makeText(getApplicationContext(),(Integer.toString(count)) + "", Toast.LENGTH_SHORT).show();

        for(int i = 0; i < count; i++){
            Donut donut = new Donut(flavor);
            curOrder.add(donut);
        }
        for (Donut donut : curOrder) {
            Toast.makeText(getApplicationContext(), (Integer.toString(count) +
                    donut.toString()), Toast.LENGTH_SHORT).show();
        }
        subtotal();

    }

    /**
     * The approveOrder method finalizes the user's donut order and adds it to an arraylist
     * of order objects that will eventually be passed back to the main activity.
     */
    private Order approveOrder (){
        Order donutOrder = new Order(orderNumber);
        for(Donut donut : curOrder)
            donutOrder.add(donut);
        orderNumber ++;
        curOrder.clear();
        subtotalDisplay = 0.00;
        return donutOrder;

    }

    /**
     * The subtotal method keeps a running total of the donut costs
     */
    public void subtotal(){
        for (Donut donut: curOrder){
            subtotalDisplay += DONUT_PRICE;

        }
        final TextView donutSubtotal = (TextView) findViewById(R.id.subtotalDonut);
        donutSubtotal.setText(Double.toString(subtotalDisplay));

    }

    /**
     * The review order method calls the order details activity and passes it the curOrder object
     */
    public void reviewOrder(View view){
//        ArrayList<String> orderList = new ArrayList<String>();
//        for(Donut donut: curOrder){
//            orderList.add(donut.toString());
//        }
        //Bundle passBundle = new Bundle();
        //passBundle.putSerializable(DONUT_ORDER_KEY, curOrder);
        Intent intent = new Intent(this, OrderDetails.class);
        intent.putExtra("Test", (Serializable) curOrder);
        startActivity(intent);
    }
}
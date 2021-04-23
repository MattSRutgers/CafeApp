package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.cafeapp.MainActivity.customerOrder;
import static com.example.cafeapp.MainActivity.storeOrder;
import static com.example.cafeapp.MenuItem.doubleToDollar;

/**
 * @Author Matthew Schilling and Gordon Miller
 * THe user order class keeps track of the users current order
 */
public class UserOrder extends AppCompatActivity {
    private ArrayList<Order> passList = new ArrayList<>();
    private static final double TAX_RATE = 0.06625;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);

        Intent intent = getIntent();
        ArrayList<String> asString = new ArrayList<>();
        double orderSubtotal = 0;
        double tax = 0;
        double total = 0;

        ListView orderList = (ListView) findViewById(R.id.userOrderListView);
        ArrayList<Order> userOrderList = (ArrayList<Order>) intent.getSerializableExtra("Test");
        for(Order item : userOrderList) {
            asString.add(item.toString());
            double temp =  item.getTotal();
            orderSubtotal += temp;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, asString);
        orderList.setAdapter(arrayAdapter);
        updateList(userOrderList);

        TextView subView = (TextView) findViewById(R.id.userSubValue);
        TextView taxView = (TextView) findViewById(R.id.taxValue);
        TextView totalView = (TextView) findViewById(R.id.totalValue);
        String temp = doubleToDollar(orderSubtotal);
        tax = orderSubtotal * TAX_RATE;
        total = tax + orderSubtotal;
        String totalTemp = doubleToDollar(total);
        String taxTemp = doubleToDollar(tax);
        subView.setText(temp);
        taxView.setText(taxTemp);
        totalView.setText(totalTemp);

        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                asString.remove(i);
                userOrderList.remove(i);
                updateList(userOrderList);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * This method will reflect the changes made in listview
     */
    private void updateList(ArrayList list){
        passList.clear();
        passList.addAll(list);
    }

    /**
     * The finalize order method passes the final order once the user has decided
     * @param view
     */
    public void finalizeOrder(View view){
        //make this add order items to store order list in main activity
        //then make the store orders button in main activity load the store orders just like this one
        storeOrder.addAll(passList);
        passList.clear();
        customerOrder.clear();
        finish();
    }

}
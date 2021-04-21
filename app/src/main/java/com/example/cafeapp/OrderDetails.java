package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OrderDetails extends AppCompatActivity {

    private ListView orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        orderList = (ListView) findViewById(R.id.orderDetailsListView);
        //ArrayAdapter <String> orderlist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,customerOrder);
    }
}
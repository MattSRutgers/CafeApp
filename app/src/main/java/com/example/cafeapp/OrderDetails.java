package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.cafeapp.DonutActivity.DONUT_ORDER_KEY;
import static com.example.cafeapp.MainActivity.customerOrder;

public class OrderDetails extends AppCompatActivity{
    private ArrayList<MenuItem> newOrderList = new ArrayList<>();
    //private  ArrayList<String> asString;
    private int orderNumber = 1;

    //private ListView orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        //Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        ArrayList<String> asString = new ArrayList<>();

        //ArrayList<String> curOrderList = getIntent().getExtras().getStringArrayList(DONUT_ORDER_KEY);
        //curOrderList = (ArrayList<Order>) bundle.getSerializable(DONUT_ORDER_KEY);

        ListView orderList = (ListView) findViewById(R.id.orderDetailsListView);
        ArrayList<MenuItem> curOrderList = (ArrayList<MenuItem>) intent.getSerializableExtra("Test");
        for(MenuItem item : curOrderList)
            asString.add(item.toString());

        updateList(curOrderList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, asString);
        orderList.setAdapter(arrayAdapter);
        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                asString.remove(i);
                curOrderList.remove(i);
                updateList(curOrderList);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
    private void updateList(ArrayList list){
        newOrderList.addAll(list);

    }


    public void placeOrder (View view){
        Order newOrder = new Order(orderNumber);
        for(MenuItem item : newOrderList)
            newOrder.add(item);
        orderNumber ++;
        customerOrder.add(newOrder);
        newOrderList.clear();

    }
}
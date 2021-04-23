package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.cafeapp.MainActivity.customerOrder;

/**
 * @Author Matthew Schilling and Gordon Miller
 * The orderDetails class maintains a list of menu items the user has selected
 */
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

    /**
     * The update list method mirrors changes made to the listview.
     * @param list the arraylist of menu items the user has removed from
     */
    private void updateList(ArrayList list){
        newOrderList.clear();
        newOrderList.addAll(list);

    }


    /**
     * The placeOrder method adds the users selection to their order.
     * @param view
     */
    public void placeOrder (View view){
        Order newOrder = new Order(orderNumber);
        for(MenuItem item : newOrderList)
            newOrder.add(item);
        orderNumber ++;
        customerOrder.add(newOrder);
        newOrderList.clear();
        finish();

    }
}
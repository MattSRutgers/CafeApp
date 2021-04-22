package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * @Author Matthew Schilling and Gordon miller
 * The Store orders class maintains a list of the finalized orders for the cafe.
 */
public class StoreOrders extends AppCompatActivity implements Customizable{

    private ArrayList<Order> storePlacedOrderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);

        Intent intent = getIntent();
        ArrayList<String> asString = new ArrayList<>();

        ListView orderList = (ListView) findViewById(R.id.storeOrderListView);
        ArrayList<Order> storeOrderList = (ArrayList<Order>) intent.getSerializableExtra("Test2");
        for(Order item : storeOrderList)
            asString.add(item.toString());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, asString);
        orderList.setAdapter(arrayAdapter);
        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                asString.remove(i);
                storeOrderList.remove(i);
                updateList(storeOrderList);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
    /**
     * This method will reflect the changes made in listview
     */
    private void updateList(ArrayList list){
        storePlacedOrderList.clear();
        storePlacedOrderList.addAll(list);
    }

    /**
     * The add method can add orders to the list
     * @param obj the order object to add
     * @return a boolean for success or failure
     */
    @Override
    public boolean add(Object obj) {
        if(obj != null) {
            storePlacedOrderList.add((Order)obj);
            return true;
        }
        return false;
    }

    /**
     * Remove method can remove an order from the list
     * @param obj the order to remove
     * @return boolean for success or failure
     */
    @Override
    public boolean remove(Object obj) {
        storePlacedOrderList.remove((Order) obj);
        return true;
    }
}
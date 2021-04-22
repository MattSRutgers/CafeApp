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
import static com.example.cafeapp.MainActivity.storeOrder;

public class userOrder extends AppCompatActivity {
    private ArrayList<Order> passList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);

        Intent intent = getIntent();
        ArrayList<String> asString = new ArrayList<>();

        ListView orderList = (ListView) findViewById(R.id.userOrderListView);
        ArrayList<Order> userOrderList = (ArrayList<Order>) intent.getSerializableExtra("Test");
        for(Order item : userOrderList)
            asString.add(item.toString());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, asString);
        orderList.setAdapter(arrayAdapter);
        updateList(userOrderList);
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
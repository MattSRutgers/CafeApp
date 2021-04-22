package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class userOrder extends AppCompatActivity {

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
        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                asString.remove(i);
                //curOrderList.remove(i);
                //updateList(curOrderList);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
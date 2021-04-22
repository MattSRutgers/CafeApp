package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class StoreOrders extends AppCompatActivity implements Customizable{

    private ArrayList<Order> storeOrderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
    }

    @Override
    public boolean add(Object obj) {
        if(obj != null) {
            storeOrderList.add((Order)obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        storeOrderList.remove((Order) obj);
        return true;
    }
}
package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DonutActivity extends AppCompatActivity {
    public static final String DONUT_ORDER_KEY = "com.example.cafeapp.DONUTKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);

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
        Intent intent = new Intent();
        intent.putExtra(DONUT_ORDER_KEY,"REPLACE WITH DONUT ORDER");
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
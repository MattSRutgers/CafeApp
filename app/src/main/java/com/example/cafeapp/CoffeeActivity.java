package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class CoffeeActivity extends AppCompatActivity {
    String coffeeSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            coffeeSize = ((RadioButton) view).getText().toString();
            Toast.makeText(getApplicationContext(),coffeeSize, Toast.LENGTH_SHORT).show();
        }
        }

}
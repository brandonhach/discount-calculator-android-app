package com.example.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumberDecimal;
    TextView textViewDiscounted;
    TextView textViewDiscountedPrice;

    public static final String TAG = "demo";



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Goal is to apply functionality to
        /*
        *   editText (Enter Ticket Price $$)
        *   textViewDiscounted (Displays percentage from user click from button)
        *   textViewDiscountedPrice (Display New Discounted Price)
        * */

        // Grab view from current layout
        editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);
        textViewDiscounted = findViewById(R.id.textViewDiscounted);
        textViewDiscountedPrice = findViewById(R.id.textViewDiscountedPrice);

        // Base case: Clear everything
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumberDecimal.setText("");
                textViewDiscounted.setText("");
                textViewDiscountedPrice.setText("");

            }
        });

        //if user clicks button, use calculateDiscount function
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount(5.0);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount(10.0);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount(15.0);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount(20.0);
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount(50.0);
            }
        });

    }

    //calculate Perctange
    private void calculateDiscount(double discount) {
        String enterAmount = editTextNumberDecimal.getText().toString();
        try {
            double amount = Double.valueOf(enterAmount);
            double discountedPrice = (100 - discount) * amount / 100;
            textViewDiscounted.setText(String.valueOf(discount) + "%");
            textViewDiscountedPrice.setText(String.valueOf(discountedPrice));
        } catch (Exception e) {
        Toast.makeText(MainActivity.this, "Enter a valid number!", Toast.LENGTH_SHORT).show();
        }
    }
}
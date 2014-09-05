package com.example.alexander.assignment1a;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class RandomNumberActivity extends SharedMenuActivity {

    Button randomButton;
    TextView randomResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);

        randomButton = (Button) findViewById(R.id.buttonRandom);
        randomResultTv = (TextView) findViewById(R.id.textViewResult);

        // Skapar en lyssnare på slumpknappen som visar det formaterade talet i en textvy
        randomButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Slumpar fram ett tal från 0 fram till 100 och formaterar det med 2 decimaler
                randomResultTv.setText(String.format("%.2f",Math.random()*100));
            }
        });
    }
}

package com.example.alexander.assignment1a;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;


public class BackgroundColorActivity extends SharedMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_color);
    }


    // Metoderna är kopplade till knappar och byter till respektive bakgrundsfärg

    public void onRed(View view)
    {
        setBackground(Color.RED);
    }

    public void onGreen(View view)
    {
        setBackground(Color.GREEN);
    }

    public void onBlue(View view)
    {
        setBackground(Color.BLUE);
    }

    // Ett sätt att ändra bakgrundsfärg på som ändrar själva aktivitetens bakgrundsfärg (inte layoutens)
    public void setBackground(int color)
    {
        getWindow().getDecorView().setBackgroundColor(color);
    }
}

package com.example.alexander.assignment1a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// Den här aktiviteten innehåller en gemensam meny som kan delas vidare till andra aktiviteter genom arv

public class SharedMenuActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shared_menu, menu);
        return true;
    }

    // En callback metod som Android använder för att tala om vilken sak i menyn som är vald
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Handle item selection

        // Beroende på vilket id saken i menyn har så startas olika aktiviteter
        switch (item.getItemId())
        {
            case R.id.menu_activity_contact:
                Intent newContact = new Intent(this,AddFriendsActivity.class);
                startActivity(newContact);
                return true;

            case R.id.menu_activity_background:
                Intent colorBackground = new Intent(this,BackgroundColorActivity.class);
                startActivity(colorBackground);
                return true;

            case R.id.menu_activity_random:
                Intent random = new Intent(this,RandomNumberActivity.class);
                startActivity(random);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
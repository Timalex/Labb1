package com.example.alexander.assignment1a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddFriendsActivity extends SharedMenuActivity {

    // Sparar input textfält som klassvariabler så de är lätt tillgängliga inom hela aktivitetsklassen
    private static EditText nameTv;
    private static EditText emailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Använd basklassens onCreate-metod
        super.onCreate(savedInstanceState);
        // Använd layouten som skapats för aktiviteten
        setContentView(R.layout.activity_add_friends);

        // Ladda in de XML-definierade textvyerna som EditText-objekt
        nameTv = (EditText) findViewById(R.id.editTextName);
        emailTv = (EditText) findViewById(R.id.editTextEmail);
    }



    //Kallas när användaren trycker på "Lägg till kontakt"-knappen
    public void onAddButton(View view)
    {
        // Hämta ut textsträngar från textfälten
        String name = nameTv.getText().toString();
        String email = emailTv.getText().toString();
        String toastMessage = null;


        //Trimma bort whitespace och kontrollera sedan om text saknas
        if (name.trim().equals(""))
        {
            showCenterToast(getString(R.string.toast_missing_name));
            nameTv.requestFocus();
        } // Meddela om en adress är inmatad och inte matchar mot ett e-postmönster
        else if (!(email.trim().equals("") && Patterns.EMAIL_ADDRESS.matcher(email).matches()))
        {
            showCenterToast(getString(R.string.toast_invalid_email));
            emailTv.requestFocus();
        }
        else { insertContact(name,email); }
    }

    private void showCenterToast(String message)
    {
        // Skapa ett diskret meddelande att kunna visa en kort stund i aktiviteten
        Toast forgotName = Toast.makeText(this,message, Toast.LENGTH_SHORT);
        // Meddelandet ska synas i mitten av skärmen, det syntes dåligt över det virtuella tangentbordet
        forgotName.setGravity(Gravity.CENTER,0,0);
        forgotName.show();
    }

    public void insertContact(String name, String email)
    {
        // Avsikten är att en ny kontakt ska sättas in.
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        // Skicka med namn och email som en kontakt-app bör känna igen.
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);

        // Starta en aktivitet för att verkställa vår avsikt om allt går bra
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

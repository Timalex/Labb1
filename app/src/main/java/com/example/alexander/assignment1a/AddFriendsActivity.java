package com.example.alexander.assignment1a;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import static android.util.Patterns.EMAIL_ADDRESS;


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


        //Trimma bort whitespace och kontrollera sedan om text saknas
        if (name.trim().equals(""))
        {
            nameTv.setError(getString(R.string.error_missing_name));
        } // Meddela om en adress är inmatad och inte matchar mot ett e-postmönster
        else if (!(email.trim().isEmpty()) && !(EMAIL_ADDRESS.matcher(email).matches()))
        {
            emailTv.setError(getString(R.string.error_invalid_email));
        }
        else { insertContact(name,email); }
    }


    public void insertContact(String name, String email)
    {
        // Avsikten är att en ny kontakt ska sättas in.
        Intent contactInsertion = new Intent(Intent.ACTION_INSERT);
        contactInsertion.setType(ContactsContract.Contacts.CONTENT_TYPE);

        // Skicka med namn och email som en kontakt-app bör känna igen.
        contactInsertion.putExtra(ContactsContract.Intents.Insert.NAME, name);
        contactInsertion.putExtra(ContactsContract.Intents.Insert.EMAIL, email);

        // Starta en aktivitet för att verkställa vår avsikt om allt går bra
        if (contactInsertion.resolveActivity(getPackageManager()) != null) {
            startActivity(contactInsertion);
        }
    }

}

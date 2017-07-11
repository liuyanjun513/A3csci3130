package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 *  To create new datas into Firebase.
 */
public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, numberField,businessNameField,addressField,provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessNameField=(EditText) findViewById(R.id.businessName);
        addressField=(EditText)findViewById(R.id.address);
        provinceField=(EditText)findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID =appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String businessName=businessNameField.getText().toString();
        String address=addressField.getText().toString();
        String province=provinceField.getText().toString();
        Business business = new Business(personID, number, name,businessName,address,province);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Contact");
        myRef.child(personID).setValue(business);

        Toast.makeText(this,business.getUid()+" "+business.getName()+" "+business.getNumber(),Toast.LENGTH_LONG).show();
        //appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}

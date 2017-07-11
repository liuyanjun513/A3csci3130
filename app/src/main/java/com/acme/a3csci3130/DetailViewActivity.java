package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField,businessNameField,addressField,provinceField;
    Business receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessNameField=(EditText) findViewById(R.id.businessName);
        addressField=(EditText)findViewById(R.id.address);
        provinceField=(EditText)findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.getName());
            numberField.setText(receivedPersonInfo.getNumber());
            businessNameField.setText(receivedPersonInfo.getBusinessName());
            addressField.setText(receivedPersonInfo.getAddress());
            provinceField.setText(receivedPersonInfo.getProvince());
        }
    }

    public void updateContact(View v){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference dr=db.getReference("contacts");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",nameField.getText().toString());
        map.put("number",numberField.getText().toString());
        map.put("businessName",businessNameField.getText().toString());
        map.put("address",addressField.getText().toString());
        map.put("province",provinceField.getText().toString());
        dr.child(receivedPersonInfo.getUid()).updateChildren(map);
        finish();
    }

    public void eraseContact(View v)
    {
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference dr=db.getReference("contacts");
        dr.child(receivedPersonInfo.getUid()).setValue(null);
        finish();
    }
}

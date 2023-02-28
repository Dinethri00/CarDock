package com.example.cardockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;

public class Registration extends AppCompatActivity {

    TextView RegistrationYr;
    TextView Model;
    TextView OwnerName;
    TextView Mileage;
    TextView ContactNo;

    MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        RegistrationYr = findViewById(R.id.registrationyr);
        Model = findViewById(R.id.model);
        OwnerName = findViewById(R.id.ownernm);
        Mileage = findViewById(R.id.mlg);
        ContactNo = findViewById(R.id.cntno);
        button = findViewById(R.id.submitbtn);

        ArrayList<cardd>car = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String rgyear =  RegistrationYr.getText().toString();
                String modl= Model.getText().toString();
                String ownrnm = OwnerName.getText().toString();
                String milge = Mileage.getText().toString();
                String phone = ContactNo.getText().toString();
                Boolean check = validationInfo(rgyear,modl,ownrnm,milge,phone);
                if(check == true) {
                    cardd c = new cardd();
                    c.RegistrationYr = rgyear;
                    c.Model = modl;
                    c.OwnerName = ownrnm;
                    c.Millege = milge;
                    c.ContactNo = phone;
                    car.add(c);
                    System.out.println(c.Model);
                }
            }
        });
    }

    private Boolean validationInfo(String modeln, String register_y,String enca,String mil, String phone){
        if(modeln.length() == 0){
            Model.requestFocus();
            Model.setError("Empty data provided");
            return false;
        }else if(register_y.length() == 0) {
            RegistrationYr.requestFocus();
            RegistrationYr.setError("Empty data provided");
            return false;
        }else if(enca.length()==0)
        {
            Mileage.requestFocus();
            Mileage.setError("Empty data provided");
            return false;
        }else if(mil.length()==0){
            Mileage.requestFocus();
            Mileage.setError("Empty data provided");
            return false;


        }else if(phone.length() == 0) {
            ContactNo.requestFocus();
            ContactNo.setError("Empty data provided");
            return false;
        }

        else {
            Toast.makeText(Registration.this,"Submission Successfully",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

}


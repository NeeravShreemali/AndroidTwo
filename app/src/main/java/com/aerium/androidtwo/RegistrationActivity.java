package com.aerium.androidtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class RegistrationActivity extends AppCompatActivity {

    EditText firstname, lastname;
    EditText email;
    EditText password;
    Switch department;
    RadioGroup radioGroup;
    RadioButton male, female;
    Spinner city;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        firstname = findViewById(R.id.edtFirstName);
        lastname = findViewById(R.id.edtLastName);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        department = findViewById(R.id.edtSwitch);
        radioGroup = findViewById(R.id.radioGroup);
        city = findViewById(R.id.edtCity);
        checkBox = findViewById(R.id.edtCheckbox);


    }
}
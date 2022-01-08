package com.aerium.androidtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText firstname, lastname;
    EditText email;
    EditText password;
    Switch department;
    RadioGroup radioGroup;
    RadioButton male, female;
    Spinner city;
    CheckBox checkBox;
    Button register;

    DabaseHelper dabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        dabaseHelper = new DabaseHelper(this);

        firstname = findViewById(R.id.edtFirstName);
        lastname = findViewById(R.id.edtLastName);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        department = findViewById(R.id.edtSwitch);
        radioGroup = findViewById(R.id.radioGroup);
        city = findViewById(R.id.edtCity);
        checkBox = findViewById(R.id.edtCheckbox);
        register = findViewById(R.id.button);

        AddData();
    }

    public void AddData(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String eml = email.getText().toString();
                String pass = password.getText().toString();
                String branch;
                String cityname = city.getSelectedItem().toString();
                String status = checkBox.isChecked()?"Active":"Inactive";

                if (department.isChecked()){
                    branch="IT";
                }else{
                    branch="CE";
                }

                int RadioButton = radioGroup.getCheckedRadioButtonId();
                RadioButton gender=findViewById(RadioButton);
                String Gender = gender.getText().toString();

                if (eml.equals("") || pass.equals("")){
                    Toast.makeText(RegistrationActivity.this, "Please fill the details",Toast.LENGTH_SHORT).show();
                    return;
                }
                try{
                    Boolean Inserted = dabaseHelper.insertData(fname, lname, eml, pass, branch, cityname, Gender, status);

                    if (Inserted==true){
                            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                            finish();
                            Toast.makeText(RegistrationActivity.this, "Sucssesfully Registered", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Error, Not able to regster", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Log.i("error", e.toString());
                }
            }
        });
    }
}
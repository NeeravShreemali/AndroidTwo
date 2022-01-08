package com.aerium.androidtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Key;

public class LoginActivity extends AppCompatActivity {

    EditText loginUsername, loginPasword;
    Button loginButton, registerButton;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String pref_key = "user";
    String key = "username";

    DabaseHelper dabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences(pref_key,MODE_PRIVATE);
        editor = preferences.edit();
        String data = preferences.getString(key, "");

        if (!data.equals("")){
            startActivity(new Intent(LoginActivity.this,HomeActivity.class).putExtra("username",data));
            finish();
        }

        dabaseHelper = new DabaseHelper(this);

        loginUsername = findViewById(R.id.edtLoginUsername);
        loginPasword = findViewById(R.id.edtLoginPassword);
        loginButton = findViewById(R.id.edtLoginButton);
        registerButton = findViewById(R.id.edtLoginRegsiter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = loginUsername.getText().toString();
                String Password = loginPasword.getText().toString();

                try {
                    Cursor cursor = dabaseHelper.selectData(Username,Password);
                    if (cursor.moveToFirst()){
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        editor.putString(key,Username);
                        editor.commit();
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Log.i("error", e.toString());
                }
            }
        });
    }
}
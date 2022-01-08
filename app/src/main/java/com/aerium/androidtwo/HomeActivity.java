package com.aerium.androidtwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String pref_key="Users;";
    String key="username;";
    ListView list;
    ArrayList<CustomList> arrayList;
    ListAdapter listAdapter;
    DabaseHelper dabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferences = getSharedPreferences(pref_key,MODE_PRIVATE);
        editor = preferences.edit();
        String data = preferences.getString(key,"");

        Intent intent = getIntent();
        String username =preferences.getString("username","");

        list = (ListView)findViewById(R.id.li);
        dabaseHelper = new DabaseHelper(this);

        loadData();

    }

    private void loadData() {
        arrayList = dabaseHelper.getAllData();
        listAdapter = new ListAdapter(this,arrayList);
        list.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            editor.remove("username");
            editor.commit();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
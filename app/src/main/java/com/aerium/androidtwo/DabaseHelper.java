package com.aerium.androidtwo;

import static com.aerium.androidtwo.MyUtil.COL_2;
import static com.aerium.androidtwo.MyUtil.COL_3;
import static com.aerium.androidtwo.MyUtil.COL_4;
import static com.aerium.androidtwo.MyUtil.COL_5;
import static com.aerium.androidtwo.MyUtil.COL_6;
import static com.aerium.androidtwo.MyUtil.COL_7;
import static com.aerium.androidtwo.MyUtil.COL_8;
import static com.aerium.androidtwo.MyUtil.COL_9;
import static com.aerium.androidtwo.MyUtil.SQL_CREATE;
import static com.aerium.androidtwo.MyUtil.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DabaseHelper extends SQLiteOpenHelper {
    public DabaseHelper(@Nullable Context context) {
        super(context, MyUtil.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData(String fname, String lname, String username, String password, String branch, String city, String gender, String status){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, lname);
        contentValues.put(COL_4, username);
        contentValues.put(COL_5, password);
        contentValues.put(COL_6, branch);
        contentValues.put(COL_7, gender);
        contentValues.put(COL_8, city);
        contentValues.put(COL_9, status);
        long result = db.insertOrThrow(TABLE_NAME,null,contentValues);

        if (result==-1){
            return false;
        }else
            return true;
    }

    public Cursor selectData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String select_Query = "select " +COL_4+ " ,"+COL_5+" from login where "+COL_4+ " = '"+username+"' and "+COL_5+ " = '"+password+"' ";
        Cursor cursor;
        try {
            cursor = db.rawQuery(select_Query,null);
        }catch (Exception e){
            return null;
        }
        return cursor;
    }

    public ArrayList<CustomList> getAllData(){
        ArrayList<CustomList> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("Select * from login", null);

        while (cursor.moveToNext()){
            String fname = cursor.getString(1);
            String lname = cursor.getString(2);
            String username = cursor.getString(3);
            String branch = cursor.getString(5);
            String city = cursor.getString(7);

            CustomList list = new CustomList(fname, lname, username, branch, city);
            arrayList.add(list);
        }
        return arrayList;
    }
}

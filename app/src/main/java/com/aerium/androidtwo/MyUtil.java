package com.aerium.androidtwo;

public class MyUtil {

    public static final String DATABASE_NAME = "admin_db";
    public static final String TABLE_NAME = "login";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "fname";
    public static final String COL_3 = "lname";
    public static final String COL_4 = "username";
    public static final String COL_5 = "password";
    public static final String COL_6 = "department";
    public static final String COL_7 = "gender";
    public static final String COL_8 = "city";
    public static final String COL_9 = "status";


    public static final String SQL_CREATE = "create table " +TABLE_NAME+ " ("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_2+" TEXT, "+COL_3+" TEXT, "+COL_4+" TEXT UNIQUE, "+COL_5+" TEXT, "+COL_6+ " TEXT, "+COL_7+" TEXT, "+COL_8+" TEXT, "+COL_9+" TEXT )";


}

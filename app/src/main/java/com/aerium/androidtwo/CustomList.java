package com.aerium.androidtwo;

public class CustomList {
    String fname, lname, username, branch, city;

    public CustomList(String fname, String lname, String username, String branch, String city){
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.branch = branch;
        this.city = city;
    }

    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public String getUsername(){
        return username;
    }

    public String getBranch(){
        return branch;
    }

    public String getCity(){
        return city;
    }

}

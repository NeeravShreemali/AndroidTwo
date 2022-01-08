package com.aerium.androidtwo;

import java.util.List;

public class CustomList {
    String fname, lname, username, password, branch, city;

    public CustomList(String fname, String lname, String username, String password, String branch, String city){
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
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

    public String getPassword(){
        return password;
    }

    public String getBranch(){
        return branch;
    }

    public String getCity(){
        return city;
    }

}

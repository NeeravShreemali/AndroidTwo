package com.aerium.androidtwo;

public class CustomList {
    public CustomList(String fname, String lname, String username, String branch, String city){
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.branch = branch;
        this.city = city;
    }
    String fname, lname, username, branch, city;

    public String getFname(){
        return fname;
    }
    public void setFname(String fname){
        this.fname=fname;
    }

    public String getLname(){
        return lname;
    }
    public void setLname(String lname){
        this.lname=lname;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getBranch(){
        return branch;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }
}

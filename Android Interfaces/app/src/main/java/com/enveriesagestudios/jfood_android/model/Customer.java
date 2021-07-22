package com.enveriesagestudios.jfood_android.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer{
    // instance variables
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate;

    //Constructor
    public Customer(int id, String name, String email, String password, Calendar joinDate){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;

    }
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = new GregorianCalendar(year, month-1,dayOfMonth);
    }
    public Customer(int id, String name, String email, String password){
        Calendar now = Calendar.getInstance();
        this.id = id;
        this.name = name;
        this.setEmail(email);
        this.setPassword(password);
        this.joinDate = now;
    }

    //Accessor
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public Calendar getJoinDate(){
        return joinDate;
    }

    //Mutator
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        Pattern pattern = Pattern.compile("^[\\w%&_*~]+(?:\\.[\\w&_*~]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher match = pattern.matcher(email);
        //Error check case
        if(match.find()){
            this.email = email;
        }
        else{
            this.email = "";
        }
    }
    public void setPassword(String password){
        String polaPassword ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern pattern = Pattern.compile(polaPassword);
        Matcher match = pattern.matcher(password);
        //Error check case
        if(match.find()){
            this.password = password;
        }
        else{
            this.password = "";
        }
    }
    public void setJoinDate(Calendar joinDate){
        this.joinDate = joinDate;
    }
    public void setJoinDate(int year, int month, int dayOfMonth){
        this.joinDate = new GregorianCalendar(year, month-1,dayOfMonth);
    }

    //To String
    public String toString() {
        String string = "";
        Date date = joinDate.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy");
        String formatted = formatter.format(date);
        string = "============CUSTOMER============\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Email:" + email + "\n" +
                "Password :" + password + "\n";
        if (joinDate != null) {
            string = string + "joinDate :" + date + "\n";
        }
        return string;
    }

}
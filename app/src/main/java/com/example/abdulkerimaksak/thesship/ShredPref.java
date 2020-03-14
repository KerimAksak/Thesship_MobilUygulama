package com.example.abdulkerimaksak.thesship;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

public class ShredPref {

    SharedPreferences sharedPreferences ;
    SharedPreferences sh;

    SharedPreferences.Editor editor;
    String nameSharedPref;

    public ShredPref(Context g){
        Context a=g;
        sh= a.getSharedPreferences(nameSharedPref,MODE_APPEND);
        sharedPreferences = a.getSharedPreferences(nameSharedPref,MODE_PRIVATE);
        editor=sh.edit();
    }
    public void setNameSharedPref(String nameSharedPref){
        this.nameSharedPref=nameSharedPref;
    }



    public  void putInt(String valueName,int value){
        editor.putInt(valueName,value); //int değer ekleniyor
    }
    public  void putBoolean(String valueName,boolean value){
        editor.putBoolean(valueName,value); //boolean değer ekleniyor
    }
    public  void putString(String valueName,String value){
        editor.putString(valueName,value); //boolean değer ekleniyor
    }
    public void commit(){
        editor.commit(); //Kayıt
    }

    public String getString(String name, String defValue){
        return sharedPreferences.getString(name,defValue);
    }
    public int getInt(String name, int defValue){
        return sharedPreferences.getInt(name,defValue);
    }
    public  boolean getBool(String name, boolean defValue){
        return sharedPreferences.getBoolean(name,defValue);
    }


}

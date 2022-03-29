package com.application.pm1_proyecto_final.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenPreference {

    private final SharedPreferences sharedPreferences;

    public TokenPreference(Context context){
        sharedPreferences = context.getSharedPreferences("TokenFcm", Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, Boolean value){

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public void putString(String key, String value){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    public void clear(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

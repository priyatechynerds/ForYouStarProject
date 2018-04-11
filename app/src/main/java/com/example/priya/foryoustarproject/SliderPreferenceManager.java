package com.example.priya.foryoustarproject;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PRIYA on 4/3/2018.
 */

public class SliderPreferenceManager {

    private Context context;
    private SharedPreferences sharedPreferences;
    public SliderPreferenceManager(Context context)
    {
        this.context = context;
        getSharedPreferences();
    }
    private  void getSharedPreferences()
    {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.my_preference),Context.MODE_PRIVATE);
    }
    public void writePreference()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_preference_key),"INIT_OK");
        editor.commit();
    }
    public boolean chechPreferences()
    {
        boolean status = false;
        if (sharedPreferences.getString(context.getString(R.string.my_preference_key),"null").equals("null"))
        {
            status = false;
        }
        else {
            status = true;
        }
        return status;
    }
    public void clearPrefereance()
    {
        sharedPreferences.edit().clear().commit();
    }

}

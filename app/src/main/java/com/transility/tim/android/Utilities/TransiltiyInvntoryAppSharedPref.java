package com.transility.tim.android.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Shared Prefrence class that interacts with the Shared Prefrence of the device.
 * Created by ambesh.kukreja on 6/8/2016.
 */
public class TransiltiyInvntoryAppSharedPref  {


    private static String TRANSILITY_INVENTORY_SHARED_PREF="tranility_inventory_shared_pref";
    private static String KEY_MASTER_PASSWORD="key_master_password";
    private static String KEY_USER_NAME="key_user_name";
    private static String KEY_WAS_LOGIN_SCREEN_VISIBLE="wasLoginScreenVisible";
    public static void setMasterPasswordToSharedPref(Context context,String masterPassword){

        SharedPreferences  sp=context.getSharedPreferences(TRANSILITY_INVENTORY_SHARED_PREF,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(KEY_MASTER_PASSWORD,masterPassword);
        editor.commit();



    }
    public static String getMasterPasswordToSharedPref(Context context){

        SharedPreferences sp=context.getSharedPreferences(TRANSILITY_INVENTORY_SHARED_PREF,Context.MODE_PRIVATE);
        return sp.getString(KEY_MASTER_PASSWORD,"");

    }

    public static void setUserNameToSharedPref(Context context,String userName){

    SharedPreferences sp=context.getSharedPreferences(TRANSILITY_INVENTORY_SHARED_PREF,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sp.edit();
    editor.putString(KEY_USER_NAME,userName);
    editor.commit();
}

    public static String getUserNameToSharedPref(Context context){

        SharedPreferences sp=context.getSharedPreferences(TRANSILITY_INVENTORY_SHARED_PREF,Context.MODE_PRIVATE);
        return  sp.getString(KEY_USER_NAME,"");

    }

    public static void setWasLoginScreenVisible(Context context,boolean isScreenVisible){

            SharedPreferences sp=context.getSharedPreferences(TRANSILITY_INVENTORY_SHARED_PREF,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();
        edit.putBoolean(KEY_WAS_LOGIN_SCREEN_VISIBLE,isScreenVisible);
        edit.commit();

    }
    public static boolean getWasLoginScreenVisible(Context context){

        SharedPreferences sp=context.getSharedPreferences(TRANSILITY_INVENTORY_SHARED_PREF,Context.MODE_PRIVATE);
        return  sp.getBoolean(KEY_WAS_LOGIN_SCREEN_VISIBLE,false);
    }
}

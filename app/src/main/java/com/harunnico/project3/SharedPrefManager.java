package com.harunnico.project3;

import android.content.Context;
import android.content.SharedPreferences;

import com.harunnico.project3.Model.DataUser;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;

    private static Context mContext;

    private static final String SHARED_PREF_NAME = "project3";

    private static final String KEY_PENGGUNA = "id_pengguna";

    private SharedPrefManager(Context context) {
        mContext = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(DataUser user) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_PENGGUNA, user.getIdPengguna());
        editor.apply();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_PENGGUNA, null) != null)
            return true;
        return false;
    }

    public DataUser getUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new DataUser(
                sharedPreferences.getString(KEY_PENGGUNA, null)
        );
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}

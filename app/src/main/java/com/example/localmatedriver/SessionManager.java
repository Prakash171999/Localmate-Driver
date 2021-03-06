package com.example.localmatedriver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager {
        public static final String SHARED_PREF_NAME = "register_login";
        private static final String KEY_ID = "user_id";
        public static final String KEY_USERNAME = "user_name";
        public static final String KEY_PHONENO = "user_phone";
        public static final String KEY_EMAIL = "user_email";
        public static final String KEY_DOB = "user_dob";
        public static final String KEY_DRIVERID = "driverID";
        private static SessionManager mInstance;
        private static Context ctx;

        private SessionManager(Context context) {
            ctx = context;
        }

        public static synchronized SessionManager getInstance(Context context) {
            if (mInstance == null) {
                mInstance = new SessionManager(context);
            }
            return mInstance;
        }

        //this method will store the user data in shared preferences
        public void userLogin(Users user) {
            SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USERNAME, user.getName());
            editor.putString(KEY_PHONENO, user.getPhoneno());
            editor.putString(KEY_EMAIL , user.getEmail());
            editor.putString(KEY_DOB , user.getDob());
            editor.putString(KEY_DRIVERID,user.getDriverId());
            editor.apply();
        }

        //this method will checker whether user is already logged in or not
        public boolean isLoggedIn() {
            SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USERNAME, null) != null;
        }

        //this method will give the logged in user
        public Users getUser() {
            SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return new Users(
                    sharedPreferences.getInt(KEY_ID, -1),
                    sharedPreferences.getString(KEY_USERNAME, "user_name"),
                    sharedPreferences.getString(KEY_PHONENO, "user_phone"),
                    sharedPreferences.getString(KEY_EMAIL, "user_email"),
                    sharedPreferences.getString(KEY_DOB, "user_dob"),
                    sharedPreferences.getString(KEY_DRIVERID, "driverID"))
                    ;
        }

        //this method will logout the user
        public void logout() {
            SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            ctx.startActivity(new Intent(ctx, Login.class));
        }

}

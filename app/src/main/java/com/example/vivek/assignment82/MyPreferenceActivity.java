package com.example.vivek.assignment82;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by vivek on 28-04-2016.
 */
public class MyPreferenceActivity extends PreferenceActivity {

    EditText Password, ReminderUpdation;
    CheckBox ScreenLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Password = (EditText) findViewById(R.id.Preference_password);
        ReminderUpdation = (EditText) findViewById(R.id.Preference_ReminderUpdation);
        ScreenLock = (CheckBox) findViewById(R.id.Preference_ScreenLock);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String password = sp.getString("password", " ");
        String ru = sp.getString("reminder", " ");
        Boolean check = sp.getBoolean("screenlock", false);

        Log.d("Prefs","password "+password + "; Reminder " +ru + "; check "+ check);
    }

    public static class MyPreferenceFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference_fragment);


        }
    }
}

package com.gmail.meeyeer.viinceent.androidsandbox;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity {

    public static final String TAG = SettingsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    /*
        Added the @Override method isValidFragment to test the validity of the fragment being launched.
        This is requested for subclasses of PreferenceActivity as of Android 4.4 KitKat because of a security flaw.

        http://stackoverflow.com/questions/19973034/isvalidfragment-android-api-19
        http://stackoverflow.com/questions/20954072/when-androids-isvalidfragment-from-preferenceactivity-gets-called
        http://developer.android.com/reference/android/preference/PreferenceActivity.html
    */
    protected boolean isValidFragment(String fragmentName) {
        return PreferencesFragment.class.getName().equals(fragmentName);
    }


}

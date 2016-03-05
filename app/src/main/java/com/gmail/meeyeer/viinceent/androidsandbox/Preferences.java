package com.gmail.meeyeer.viinceent.androidsandbox;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static final String TAG = Preferences.class.getSimpleName();

    public static final String PREFERENCE_KEY = "com.gmail.meeyeer.viinceent.androidsandbox.preferences";
    public static final String PREFERENCE_SWITCH1 = "com.gmail.meeyeer.viinceent.androidsandbox.preference_switch1";
    public static final String PREFERENCE_SWITCH2 = "com.gmail.meeyeer.viinceent.androidsandbox.preference_switch2";
    private static Preferences instance = null;
    private static Context context;

    private boolean isSwitch1Enabled;
    private boolean isSwitch2Enabled;

    private Preferences() {
        String preferencesName = String.format("%s.%s",
                PREFERENCE_KEY,
                context.getString(R.string.app_name));

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        if (sharedPreferences == null) return;

        isSwitch1Enabled = sharedPreferences.getBoolean(PREFERENCE_SWITCH1, true);
        isSwitch2Enabled = sharedPreferences.getBoolean(PREFERENCE_SWITCH2, true);

    }

    public static synchronized Preferences getInstance(Context context) {
        if (instance != null) return instance;
        if (context == null) return null;
        Preferences.context = context.getApplicationContext();
        instance = new Preferences();
        return instance;
    }


}

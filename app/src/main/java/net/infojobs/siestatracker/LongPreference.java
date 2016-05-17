package net.infojobs.siestatracker;

import android.content.SharedPreferences;

public class LongPreference {

    private final String key;
    private final SharedPreferences sharedPreferences;

    public LongPreference(String key, SharedPreferences sharedPreferences) {
        this.key = key;
        this.sharedPreferences = sharedPreferences;
    }

    public boolean hasValue() {
        return sharedPreferences.contains(key);
    }

    public Long get() {
        return sharedPreferences.getLong(key, 0L);
    }

    public void set(Long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }
}

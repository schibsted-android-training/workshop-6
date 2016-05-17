package net.infojobs.siestatracker;

import android.content.SharedPreferences;

import net.infojobs.siestatracker.domain.SiestaDataSource;

import java.util.Date;

public class SharedPreferenceSiestaDataSource implements SiestaDataSource {

    private final SharedPreferences sharedPreferences;

    public SharedPreferenceSiestaDataSource(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Date getLastSiestaDate() {
        if (sharedPreferences.contains("LAST_SIESTA")) {
            long lastSiestaTimestamp = sharedPreferences.getLong("LAST_SIESTA", 0L);
            return new Date(lastSiestaTimestamp);
        } else {
            return null;
        }
    }

    @Override
    public void saveLastSiesta(Date lastSiesta) {
        sharedPreferences.edit().putLong("LAST_SIESTA", lastSiesta.getTime()).apply();
    }
}

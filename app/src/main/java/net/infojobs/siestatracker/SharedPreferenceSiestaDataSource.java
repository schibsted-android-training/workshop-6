package net.infojobs.siestatracker;

import net.infojobs.siestatracker.domain.SiestaDataSource;

import java.util.Date;

public class SharedPreferenceSiestaDataSource implements SiestaDataSource {

    private final LongPreference lastSiestaPreference;

    public SharedPreferenceSiestaDataSource(LongPreference lastSiestaPreference) {
        this.lastSiestaPreference = lastSiestaPreference;
    }

    @Override
    public Date getLastSiestaDate() {
        if (lastSiestaPreference.hasValue()) {
            return new Date(lastSiestaPreference.get());
        } else {
            return null;
        }
    }

    @Override
    public void saveLastSiesta(Date lastSiesta) {
        lastSiestaPreference.set(lastSiesta.getTime());
    }
}

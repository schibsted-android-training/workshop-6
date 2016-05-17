package net.infojobs.siestatracker;

import net.infojobs.siestatracker.domain.SiestaDataSource;

import java.util.Date;

public class MemorySiestaDataSource implements SiestaDataSource {

    private Date lastSiesta = new Date();

    @Override
    public Date getLastSiestaDate() {
        return lastSiesta;
    }
}

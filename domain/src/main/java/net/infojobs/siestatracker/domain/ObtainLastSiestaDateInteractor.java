package net.infojobs.siestatracker.domain;

import java.util.Date;

public class ObtainLastSiestaDateInteractor {

    private final SiestaDataSource siestaDataSource;

    public ObtainLastSiestaDateInteractor(SiestaDataSource siestaDataSource) {
        this.siestaDataSource = siestaDataSource;
    }

    public Date obtainLastSiesta() {
        Date lastSiestaDate = siestaDataSource.getLastSiestaDate();
        if (lastSiestaDate == null) {
            return null;
        }
        return lastSiestaDate;
    }
}

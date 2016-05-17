package net.infojobs.siestatracker.domain;

import java.util.Date;

public class SaveNewSiestaInteractor {

    private final SiestaDataSource siestaDataSource;

    public SaveNewSiestaInteractor(SiestaDataSource siestaDataSource) {
        this.siestaDataSource = siestaDataSource;
    }

    public void saveNewSiesta() {
        siestaDataSource.saveLastSiesta(new Date(0));
    }
}

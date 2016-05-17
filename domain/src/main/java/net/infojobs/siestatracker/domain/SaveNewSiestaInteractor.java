package net.infojobs.siestatracker.domain;

public class SaveNewSiestaInteractor {

    private final SiestaDataSource siestaDataSource;
    private final Clock clock;

    public SaveNewSiestaInteractor(SiestaDataSource siestaDataSource, Clock clock) {
        this.siestaDataSource = siestaDataSource;
        this.clock = clock;
    }

    public void saveNewSiesta() {
        siestaDataSource.saveLastSiesta(clock.getCurrentDate());
    }
}

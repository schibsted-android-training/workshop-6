package net.infojobs.siestatracker.domain;

import java.util.Date;

public interface SiestaDataSource {

    Date getLastSiestaDate();

    void saveLastSiesta(Date lastSiesta);
}

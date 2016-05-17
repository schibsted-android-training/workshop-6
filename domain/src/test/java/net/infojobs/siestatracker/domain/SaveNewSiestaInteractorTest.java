package net.infojobs.siestatracker.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaveNewSiestaInteractorTest {

    @Mock
    SiestaDataSource siestaDataSource;
    @Mock
    Clock clock;

    @Test
    public void should_store_some_date() throws Exception {
        SaveNewSiestaInteractor saveNewSiestaInteractor = new SaveNewSiestaInteractor(siestaDataSource, clock);
        saveNewSiestaInteractor.saveNewSiesta();

        verify(siestaDataSource).saveLastSiesta(any(Date.class));
    }

    @Test
    public void should_store_current_date() throws Exception {
        Date currentDate = new Date();
        when(clock.getCurrentDate()).thenReturn(currentDate);

        SaveNewSiestaInteractor saveNewSiestaInteractor = new SaveNewSiestaInteractor(siestaDataSource, clock);
        saveNewSiestaInteractor.saveNewSiesta();

        verify(siestaDataSource).saveLastSiesta(currentDate);
    }
}
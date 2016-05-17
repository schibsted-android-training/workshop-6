package net.infojobs.siestatracker.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveNewSiestaInteractorTest {

    @Mock
    SiestaDataSource siestaDataSource;

    @Test
    public void should_store_some_date() throws Exception {
        SaveNewSiestaInteractor saveNewSiestaInteractor = new SaveNewSiestaInteractor(siestaDataSource);
        saveNewSiestaInteractor.saveNewSiesta();

        verify(siestaDataSource).saveLastSiesta(any(Date.class));
    }
}
package net.infojobs.siestatracker.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ObtainLastSiestaDateInteractorTest {

    @Mock
    SiestaDataSource siestaDataSource;

    @Test
    public void should_return_date_when_data_source_returns_date() throws Exception {
        Date storedSiestaDate = new Date();
        when(siestaDataSource.getLastSiestaDate()).thenReturn(storedSiestaDate);

        ObtainLastSiestaDateInteractor interactor = new ObtainLastSiestaDateInteractor(siestaDataSource);
        Date receivedSiestaDate = interactor.obtainLastSiesta();

        assertEquals(storedSiestaDate, receivedSiestaDate);
    }

    @Test
    public void should_return_null_exception_when_data_source_returns_null() throws Exception {
        Date storedSiestaDate = null;
        when(siestaDataSource.getLastSiestaDate()).thenReturn(storedSiestaDate);

        ObtainLastSiestaDateInteractor interactor = new ObtainLastSiestaDateInteractor(siestaDataSource);
        Date receivedSiestaDate = interactor.obtainLastSiesta();

        assertNull(receivedSiestaDate);
    }
}
package net.infojobs.siestatracker.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
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

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_when_data_source_returns_null() throws Exception {
        when(siestaDataSource.getLastSiestaDate()).thenReturn(null);

        ObtainLastSiestaDateInteractor interactor = new ObtainLastSiestaDateInteractor(siestaDataSource);
        interactor.obtainLastSiesta();
    }
}
package net.infojobs.siestatracker;

import net.infojobs.siestatracker.domain.ObtainLastSiestaDateInteractor;
import net.infojobs.siestatracker.domain.SaveNewSiestaInteractor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SiestaPresenterTest {

    @Mock
    SiestaPresenter.View view;
    @Mock
    ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor;
    @Mock
    SaveNewSiestaInteractor saveNewSiestaInteractor;
    private SiestaPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new SiestaPresenter(obtainLastSiestaDateInteractor, saveNewSiestaInteractor);
        presenter.setView(view);
    }

    @Test
    public void should_show_date_as_text_when_date_received() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 28);
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 7);
        Date lastSiestaDate = new Date(calendar.getTimeInMillis());
        when(obtainLastSiestaDateInteractor.obtainLastSiesta()).thenReturn(lastSiestaDate);

        presenter.initialize();

        verify(view).showLastSiestaDate("21:07, 28/02/2016");
    }

    @Test
    public void should_show_empty_message_when_null_date_received() throws Exception {
        when(obtainLastSiestaDateInteractor.obtainLastSiesta()).thenReturn(null);

        presenter.initialize();

        verify(view).showNoSiestaMessage();
    }

    @Test
    public void should_save_new_siesta_when_update_siesta_clicked() throws Exception {
        when(obtainLastSiestaDateInteractor.obtainLastSiesta()).thenReturn(new Date());

        presenter.onUpdateSiestaClick();

        verify(saveNewSiestaInteractor).saveNewSiesta();
    }

    @Test
    public void should_show_date_as_text_when_update_siesta_clicked() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 28);
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 7);
        Date lastSiestaDate = new Date(calendar.getTimeInMillis());
        when(obtainLastSiestaDateInteractor.obtainLastSiesta()).thenReturn(lastSiestaDate);

        presenter.onUpdateSiestaClick();

        verify(view).showLastSiestaDate("21:07, 28/02/2016");
    }
}
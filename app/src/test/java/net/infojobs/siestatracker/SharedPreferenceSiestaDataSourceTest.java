package net.infojobs.siestatracker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SharedPreferenceSiestaDataSourceTest {

    @Mock
    LongPreference lastSiestaPreference;

    private SharedPreferenceSiestaDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new SharedPreferenceSiestaDataSource(lastSiestaPreference);
    }

    @Test
    public void should_set_timestamp_value_when_save_date() throws Exception {
        Date date = new Date(42L);

        dataSource.saveLastSiesta(date);

        verify(lastSiestaPreference).set(42L);
    }

    @Test
    public void should_return_date_when_preference_contains_timestamp() throws Exception {
        when(lastSiestaPreference.hasValue()).thenReturn(true);
        when(lastSiestaPreference.get()).thenReturn(42L);

        Date result = dataSource.getLastSiestaDate();

        assertEquals(new Date(42L), result);
    }

    @Test
    public void should_return_null_when_preference_doesnt_contain_timestamp() throws Exception {
        when(lastSiestaPreference.hasValue()).thenReturn(false);

        Date result = dataSource.getLastSiestaDate();

        assertNull(result);
    }
}
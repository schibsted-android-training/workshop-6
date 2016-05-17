package net.infojobs.siestatracker;

import net.infojobs.siestatracker.domain.ObtainLastSiestaDateInteractor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SiestaPresenter {

    private final ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor;

    public SiestaPresenter(ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor) {
        this.obtainLastSiestaDateInteractor = obtainLastSiestaDateInteractor;
    }

    public void initialize(View view) {
        Date date = obtainLastSiestaDateInteractor.obtainLastSiesta();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm, dd/MM/yyyy", new Locale("es", "ES"));
        String dateText = dateFormat.format(date);
        view.showLastSiestaDate(dateText);
    }

    interface View {

        void showLastSiestaDate(String lastDate);
    }
}

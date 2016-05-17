package net.infojobs.siestatracker;

import net.infojobs.siestatracker.domain.ObtainLastSiestaDateInteractor;
import net.infojobs.siestatracker.domain.SaveNewSiestaInteractor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SiestaPresenter {

    private final ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor;
    private final SaveNewSiestaInteractor saveNewSiestaInteractor;

    public SiestaPresenter(ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor, SaveNewSiestaInteractor saveNewSiestaInteractor) {
        this.obtainLastSiestaDateInteractor = obtainLastSiestaDateInteractor;
        this.saveNewSiestaInteractor = saveNewSiestaInteractor;
    }

    public void initialize(View view) {
        Date date = obtainLastSiestaDateInteractor.obtainLastSiesta();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm, dd/MM/yyyy", new Locale("es", "ES"));
        String dateText = dateFormat.format(date);
        view.showLastSiestaDate(dateText);
    }

    public void onUpdateSiestaClick() {
        saveNewSiestaInteractor.saveNewSiesta();
    }

    interface View {

        void showLastSiestaDate(String lastDate);
    }
}

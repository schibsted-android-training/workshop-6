package net.infojobs.siestatracker;

import net.infojobs.siestatracker.domain.ObtainLastSiestaDateInteractor;
import net.infojobs.siestatracker.domain.SaveNewSiestaInteractor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SiestaPresenter {

    private final ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor;
    private final SaveNewSiestaInteractor saveNewSiestaInteractor;

    private View view;

    public SiestaPresenter(ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor, SaveNewSiestaInteractor saveNewSiestaInteractor) {
        this.obtainLastSiestaDateInteractor = obtainLastSiestaDateInteractor;
        this.saveNewSiestaInteractor = saveNewSiestaInteractor;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void initialize() {
        updateLastSiestaText();
    }

    public void onUpdateSiestaClick() {
        saveNewSiestaInteractor.saveNewSiesta();
        updateLastSiestaText();
    }

    private void updateLastSiestaText() {
        Date date = obtainLastSiestaDateInteractor.obtainLastSiesta();
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm, dd/MM/yyyy", new Locale("es", "ES"));
            String dateText = dateFormat.format(date);
            view.showLastSiestaDate(dateText);
        } else {
            view.showNoSiestaMessage();
        }
    }

    interface View {

        void showLastSiestaDate(String lastDate);

        void showNoSiestaMessage();
    }
}

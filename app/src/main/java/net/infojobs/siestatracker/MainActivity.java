package net.infojobs.siestatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.infojobs.siestatracker.domain.ObtainLastSiestaDateInteractor;
import net.infojobs.siestatracker.domain.SaveNewSiestaInteractor;
import net.infojobs.siestatracker.domain.SiestaDataSource;

public class MainActivity extends AppCompatActivity implements SiestaPresenter.View {

    private TextView lastDateText;

    private SiestaPresenter presenter;
    private Button updateSiestaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastDateText = ((TextView) findViewById(R.id.last_date_text));
        updateSiestaButton = ((Button) findViewById(R.id.update_siesta_button));
        updateSiestaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onUpdateSiestaClick();
            }
        });

        SiestaDataSource siestaDataSource = new MemorySiestaDataSource();
        ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor = new ObtainLastSiestaDateInteractor(siestaDataSource);
        SaveNewSiestaInteractor saveNewSiestaInteractor = new SaveNewSiestaInteractor();
        presenter = new SiestaPresenter(obtainLastSiestaDateInteractor, saveNewSiestaInteractor);

        presenter.setView(this);
        presenter.initialize();
    }

    @Override
    public void showLastSiestaDate(String lastDate) {
        lastDateText.setText(lastDate);
    }
}

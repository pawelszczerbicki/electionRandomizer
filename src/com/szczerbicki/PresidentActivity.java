package com.szczerbicki;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pawel on 27.04.15.
 */
public class PresidentActivity extends SensorDetector{

    private PresidentService service = new PresidentService();

    private TextView presidentName;
    private TextView party;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.president);
        presidentName = (TextView) findViewById(R.id.presidentName);
        party = (TextView) findViewById(R.id.party);
        showMyPresident(null);
    }

    @Override
    protected void shakeDetected() {
        showMyPresident(null);
    }

    public void showMyPresident(View v) {
        President p = service.random();
        presidentName.setText(p.getName());
        party.setText(p.getParty());
    }
}
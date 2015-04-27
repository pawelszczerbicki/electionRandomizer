package com.szczerbicki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends SensorDetector {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void shakeDetected() {
        runPresidentActivity(null);
    }

    public void runPresidentActivity(View v) {
        startActivity(new Intent(this, PresidentActivity.class));
    }
}

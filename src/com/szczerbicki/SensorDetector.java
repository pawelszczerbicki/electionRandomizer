package com.szczerbicki;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;
import static android.hardware.SensorManager.SENSOR_DELAY_NORMAL;

/**
 * Created by pawel on 27.04.15.
 */
public abstract class SensorDetector extends Activity implements SensorEventListener {

    private SensorManager manager;
    private float accel;
    private float accelCurrent;
    private float accelLast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        manager.registerListener(this, manager.getDefaultSensor(TYPE_ACCELEROMETER), SENSOR_DELAY_NORMAL);
        accel = 0.00f;
        accelCurrent = SensorManager.GRAVITY_EARTH;
        accelLast = SensorManager.GRAVITY_EARTH;
    }

    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        accelLast = accelCurrent;
        accelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
        float delta = accelCurrent - accelLast;
        accel = accel * 0.9f + delta;
        if (accel > 10) shakeDetected();
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //intentionally empty
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this, manager.getDefaultSensor(TYPE_ACCELEROMETER), SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        manager.unregisterListener(this);
        super.onPause();
    }

    protected abstract void shakeDetected();
}

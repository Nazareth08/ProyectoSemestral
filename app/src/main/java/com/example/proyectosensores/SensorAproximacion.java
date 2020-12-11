package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorAproximacion extends AppCompatActivity implements SensorEventListener {

    TextView tv1;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_aproximacion);
        tv1=(TextView)findViewById(R.id.tv);
        ln =(LinearLayout)findViewById(R.id.activityid);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String sensor1 = String.valueOf(sensorEvent.values[0]);
        tv1.setText(sensor1);
        float valor = Float.parseFloat(sensor1);
        if (valor== 0){
           ln.setBackgroundColor(Color.BLUE);
        }
        else{
            ln.setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) { }
}
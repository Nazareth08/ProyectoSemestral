package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Vibrator;
public class Sensor_aproximacion extends AppCompatActivity implements SensorEventListener {

    TextView tv1,tv2;

    SensorManager sm;
    Sensor sensor;
//hola soy ana
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_aproximacion);
        tv1=(TextView)findViewById(R.id.tv);
        tv2=(TextView)findViewById(R.id.muestra);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String sensor1 = String.valueOf(sensorEvent.values[0]);
        if (Double.parseDouble(sensor1)>0){
            tv2.setText("FUERA DE RANGO");
            tv2.setTextColor(Color.RED);
    }else{
            tv2.setText("DETECTADO");
            tv2.setTextColor(Color.GREEN);
        }
        tv1.setText(sensor1);}


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) { }
}
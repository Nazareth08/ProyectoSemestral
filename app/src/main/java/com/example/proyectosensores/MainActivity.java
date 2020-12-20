package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// PROBANDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
    }

    //pasar del activity principal al activity acelerometro
    public void Acelerometro (View view){
        Intent i = new Intent(this,Acelerometro.class);
        startActivity(i);

    //pasar del activity principal al activity de sensor de aproximacion
    }
    public void SensorAproximacion (View view){
        Intent i = new Intent(this, Sensor_aproximacion.class);
        startActivity(i);

    }
    //pasar del activity principal al activity de GPs
    public void Gps (View view){
        Intent i = new Intent(this,Gps.class);
        startActivity(i);
    }
}
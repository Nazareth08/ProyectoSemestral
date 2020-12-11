package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //HOLAAAA
//ya estan los cambios hechos
    }
    //pasar del activity principal al activity de sensor luz
    public void SensorLuz (View view){
        Intent i = new Intent(this,SensorLuz.class);
        startActivity(i);

    }
    public void SensorAproximacion (View view){
        Intent i = new Intent(this,SensorAproximacion.class);
        startActivity(i);

    }
    public void Gps (View view){
        Intent i = new Intent(this,Gps.class);
        startActivity(i);
    }
}
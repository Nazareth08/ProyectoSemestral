package com.example.proyectosensores;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gps extends AppCompatActivity {
    Button btnGPS;
    TextView tvUbicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        //instancias
        tvUbicacion = (TextView) findViewById(R.id.tvUbicacion);
        btnGPS = (Button) findViewById(R.id.button_Gps);

        btnGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationManager locationManager = (LocationManager)Gps.this.getSystemService(Context.LOCATION_SERVICE);
                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        //cuando cambie de ubicacion mostrar el cambio
                        tvUbicacion.setText(" "+location.getLatitude()+" "+location.getLongitude());
                    }

                    public void onStatusChanged(String provider, int Status, Bundle Extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                    }

                };
                //solicitar permiso para encontrar la ubicacion (Fine Location)
                int permissionCheck = ContextCompat.checkSelfPermission(Gps.this, Manifest.permission.ACCESS_FINE_LOCATION);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
            }
        });


        //solicitar permiso para encontrar la ubicacion (Fine Location)
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        //si no tenemos permiso (procedemos a solicitarlo)
        if(permissionCheck == PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }

    }}

package com.example.marcelopaglione.sensores_exe3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_foto) {
            PackageManager packageManager = MainActivity.this.getPackageManager();
            if( packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) ) {
                Intent i = new Intent(MainActivity.this,Activity_tirarFoto.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this,"Este dispositivo não possui camera",Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        if (id == R.id.menu_video) {
            PackageManager packageManager = MainActivity.this.getPackageManager();
            if( packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) ) {
                Intent i = new Intent(MainActivity.this,Activity_video.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this,"Este dispositivo não possui camera",Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        if (id == R.id.menu_gps) {

            if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
            else {
                Intent i = new Intent(MainActivity.this,Activity_gps.class);
                startActivity(i);
            }



            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.marcelopaglione.sensores_exe3;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Activity_gps extends Activity {

    Button bt1;
    Context context;
    LocationManager locationManager;
    Location locUtf = new Location("UTFPR Location");
    double distance = 0;


    ArrayAdapter<Localizacao> locArrayAdapter;
    List<Localizacao> locList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_gps);
        locUtf.setLatitude(-23.18);
        locUtf.setLongitude(-50.65);
        locList = new ArrayList<>();
        context = this;
        bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(bt1Listener);
        listView = (ListView)findViewById(R.id.listView);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locArrayAdapter = new ArrayAdapter<>(Activity_gps.this, android.R.layout.simple_list_item_1, locList);
        listView.setAdapter(locArrayAdapter);
    }

    private View.OnClickListener bt1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 1, locationListener);
        }
    };

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onLocationChanged(Location location) {
            DecimalFormat df = new DecimalFormat("#.0000");
            String fLat = df.format( location.getLatitude() );
            String fLong = df.format( location.getLongitude() );

            Location locB = new Location("Segunda loc");
            locB.setLatitude(location.getLatitude());
            locB.setLongitude(location.getLongitude());

            double distCalculada = locUtf.distanceTo(locB);
            if(distCalculada>distance){
                Toast.makeText(context,"Você está cada vez mais longe da UTFPR!",Toast.LENGTH_SHORT).show();
                distance=distCalculada;
                locList.add(new Localizacao(Double.parseDouble(fLat),Double.parseDouble(fLong)));
                if(locList.size()>1) {
                    for (int i = locList.size() - 1; i > 0; i--) {
                        locList.set(i, locList.get(i - 1));
                    }
                    locList.set(0, new Localizacao(Double.parseDouble(fLat),Double.parseDouble(fLong)));
                }
                locArrayAdapter.notifyDataSetChanged();
            }
            else {
                Toast.makeText(context,"Você está cada vez mais perto da UTFPR!",Toast.LENGTH_SHORT).show();
                distance=distCalculada;
                locList.add(new Localizacao(Double.parseDouble(fLat),Double.parseDouble(fLong)));
                if(locList.size()>1) {
                    for (int i = locList.size() - 1; i > 0; i--) {
                        locList.set(i, locList.get(i - 1));
                    }
                    locList.set(0, new Localizacao(Double.parseDouble(fLat),Double.parseDouble(fLong)));
                }
                locArrayAdapter.notifyDataSetChanged();
            }

        }
    };

}

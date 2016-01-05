package com.example.marcelopaglione.sensores_exe3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DecimalFormat;

public class Activity_tirarFoto extends AppCompatActivity {

    int fotoNumber = 0;
    String photoName;
    Context context;
    LocationManager locationManager;
    LinearLayout locLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_tirar_foto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, getCaminhoArquivo());

        if(i.resolveActivity(Activity_tirarFoto.this.getPackageManager()) != null) {
            startActivityForResult(i, 34);
        }
        else {
            Toast.makeText(Activity_tirarFoto.this, "There is no app to capture image!", Toast.LENGTH_SHORT).show();
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 34) {
            if (resultCode == RESULT_OK) {
                Uri takenPhotoUri = Uri.fromFile(new File(photoName));
                Bitmap takenImage = BitmapFactory.decodeFile(takenPhotoUri.getPath());
                ImageView ivPreview = (ImageView) findViewById(R.id.imageView);
                ivPreview.setImageBitmap(takenImage);

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListener);


            }
            else {
                Toast.makeText(this, "Picture was not taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected Uri getCaminhoArquivo() {
        File diretorioMidia = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "medias06");

        if (!diretorioMidia.exists() && !diretorioMidia.mkdirs())
            Log.d("medias06", "error creating the file");

        fotoNumber++;
        String fileName = "foto" + fotoNumber + ".jpg";
        photoName = diretorioMidia.getPath() + File.separator + fileName;

        return Uri.fromFile(new File(photoName));
    }

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
            String msg = "Latitude: " + fLat + "\nLongitude: " + fLong;
            Toast.makeText(context,"msg: "+msg,Toast.LENGTH_LONG).show();

        }
    };
}

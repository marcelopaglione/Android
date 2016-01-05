package com.example.marcelopaglione.sensores_exe3;

/**
 * Created by marcelopaglione on 11/27/15.
 */
public class Localizacao {
    private double latitude;
    private double longitude;

    public Localizacao(double lat, double longi){
        latitude=lat;
        longitude = longi;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String toString(){
        return "Latitude: "+latitude + "\nLongitude: "+longitude;
    }

}

package com.example.android.quakereport;

import java.io.Serializable;

/**
 * Created by ProJava on 8/25/2016.
 */
public class Earthquake implements Serializable {

    private double mag;
    private String city;
    private String date;
    private String time;
    private String url;

    public Earthquake()
    {
        super();
    }


    public Earthquake(double mag, String city, String date) {
        this.mag = mag;
        this.city = city;
        this.date = date;
    }




    public Earthquake(double mag, String city, String date, String time) {
        this.mag = mag;
        this.city = city;
        this.date = date;
        this.time = time;
    }

    public Earthquake(double mag, String city, String date, String time, String url) {
        this.mag = mag;
        this.city = city;
        this.date = date;
        this.time = time;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    @Override
    public String toString() {
        return getMag() + " " + getCity() + " " + getMag() +" " + getTime();
    }
}

package com.alisakralarabygmail.cairotourguide;

import java.util.ArrayList;

/**
 * Created by ali on 8/22/2017.
 */

public class CustomItemClass {

    private String label;
    private int imageUri;
    private double latitude;
    private double longtude;
    public CustomItemClass(String label, int imgUri, double latitude, double longtude){

        this.label = label;
        this.imageUri = imgUri;
        this.latitude = latitude;
        this.longtude = longtude;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getImageUri() {
        return imageUri;
    }

    public void setImageUri(int imageUri) {
        this.imageUri = imageUri;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtude() {
        return longtude;
    }

    public void setLongtude(double longtude) {
        this.longtude = longtude;
    }
}

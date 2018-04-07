package com.example.cr7.model;

import java.io.Serializable;

/**
 * Created by CR7 on 3/12/2018.
 */

public class UserPosition implements Serializable {
    private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public UserPosition(double lat, double lon, String name, String image, String distance) {

        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.image = image;
        this.distance = distance;
    }

    private String name;
    private String image;
    private String distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public UserPosition(String name, String image, String distance) {

        this.name = name;
        this.image = image;
        this.distance = distance;
    }
}

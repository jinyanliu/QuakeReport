package com.example.android.quakereport;

/**
 * Created by jane on 11/14/16.
 * Represents an earthquake.
 * It contains the magnitude, location and date of an earthquake.
 */

public class Earthquake {

    /**
     * Magnitude of the earthquake
     */
    private float mMagnitude;

    /**
     * Location of the earthquake
     */
    private String mLocation;

    /**
     * Date of the earthquake
     */
    private String mDate;

    /**
     * Create a new Earthquake object.
     *
     * @param magnitude is the magnitude of the earthquake
     * @param location  is the location of the earthquake
     * @param date      is the date of the earthquake
     */
    public Earthquake(float magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    /**
     * Get the magnitude of the earthquake
     */
    public float getMagnitude() {
        return mMagnitude;
    }

    /**
     * Get the location of the earthquake
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Get the date of the earthquake
     */
    public String getDate() {
        return mDate;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude=" + mMagnitude +
                ", mLocation='" + mLocation + '\'' +
                ", mDate='" + mDate + '\'' +
                '}';
    }

}

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
    private String mMagnitude;

    /**
     * Location of the earthquake
     */
    private String mLocation;

    /**
     * Time of the earthquake
     */
    private long mTimeInMilliseconds;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude          is the magnitude of the earthquake
     * @param location           is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the earthquake happened
     */
    public Earthquake(String magnitude, String location, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    /**
     * Get the magnitude of the earthquake
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     * Get the location of the earthquake
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Get the time of the earthquake
     */
    public long getTimeInMilliseconds() {

        return mTimeInMilliseconds;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude='" + mMagnitude + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mTimeInMilliseconds=" + mTimeInMilliseconds +
                '}';
    }
}

package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude;
    private String mLocation;
    private String mDate;

    public Earthquake(String magnitude,String location, String date) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mDate = date;
    }

    /**
     *  This method is used to return the magnitude value of the earthquake
     * @return mMagnitude
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     *  This method is used to return the location value of the earthquake
     * @return mLocation
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     *  This method is used to return the date value of the earthquake
     * @return mDate
     */
    public String getDate() {
        return mDate;
    }
}


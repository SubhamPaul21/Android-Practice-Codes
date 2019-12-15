package com.example.android.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTime;
    private String mOffset;
    private String mUrl;

    public Earthquake(double magnitude,String offset,String location, long time, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTime = time;
        this.mOffset = offset;
        this.mUrl = url;
    }

    /**
     *  This method is used to return the magnitude value of the earthquake
     * @return mMagnitude
     */
    public Double getMagnitude() {
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
     *  This method is used to return the offset value of the earthquake
     * @return mOffset
     */
    public String getOffset() {
        return mOffset;
    }

    /**
     *  This method is used to return the date value of the earthquake
     * @return mDate
     */
    public long getTime() {
        return mTime;
    }

    /**
     *  This method is used to return the url value of the earthquake
     * @return mUrl
     */
    public String getUrl() {
        return mUrl;
    }
}


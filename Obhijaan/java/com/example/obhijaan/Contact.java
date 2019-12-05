package com.example.obhijaan;

public class Contact {

    // declaring the member variables
    private String mName;
    private String mNumber;
    private String mAddress;
    private int mImageResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

    // Creating the constructor
    public Contact(String name, String number, String address, int imageResourceId) {
        this.mName = name;
        this.mNumber = number;
        this.mAddress = address;
        this.mImageResourceId = imageResourceId;
    }

    /**
     *  This method returns the name of the helper member of the organization
     * @return mName
     */
    public String getName() {
        return mName;
    }

    /**
     *  This method returns the contact number of the helper member of the organization
     * @return mNumber
     */
    public String getNumber() {
        return mNumber;
    }

    /**
     *  This method returns the address of the helper member of the organization
     * @return mAddress
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     *  This method returns the image resource id of the helper member of the organization
     * @return mImageResourceId
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //Checking whether or not there is an image of the helper
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}

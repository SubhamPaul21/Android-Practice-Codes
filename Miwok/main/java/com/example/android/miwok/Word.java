package com.example.android.miwok;

public class Word {

    // Defining the variables of the class
    private String mEnglishWord;
    private String mMiwokWord;
    private int mAudioResourceId;
    private int  mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Creating the constructor of the Word Class with the Image Resource Id
     * @param englishWord is the english translation of the word
     * @param miwokWord is the miwok translation of the word
     * @param audioResourceId is the raw audio resource Id of the corresponding Audio
     */
    public Word(String englishWord, String miwokWord, int audioResourceId) {
        this.mEnglishWord = englishWord;
        this.mMiwokWord = miwokWord;
        this.mAudioResourceId = audioResourceId;
    }

    /**
     * Creating the constructor of the Word Class with the Image Resource Id
     * @param englishWord is the english translation of the word
     * @param miwokWord is the miwok translation of the word
     * @param imageResourceId   is the drawable resource Id of the corresponding Image
     * @param audioResourceId is the raw audio resource Id of the corresponding Audio
     */
    public Word(String englishWord, String miwokWord, int imageResourceId, int audioResourceId) {
        this.mAudioResourceId = audioResourceId;
        this.mEnglishWord = englishWord;
        this.mMiwokWord = miwokWord;
        this.mImageResourceId = imageResourceId;
    }

    //  Getting the Default Translation of the word
    public String getEnglishTranslation() {
        return mEnglishWord;
    }

    //  Getting the Miwok Translation of the word
    public String getMiwokTranslation() {
        return mMiwokWord;
    }

    //  Getting the Image Resource ID of the word
    public int getImageResourceID() {
        return mImageResourceId;
    }

    //  Getting whether or not there is an image for this word
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    // Getting the Audio Resource ID of the audio
    public int getAudioResourceID() {
        return mAudioResourceId;
    }

}



















































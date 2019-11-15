package com.example.android.miwok;

public class Word {

    // Defining the variables of the class
    private String mEnglishWord;
    private String mMiwokWord;

    // Creating the constructor of the Word Class
    public Word(String englishWord, String miwokWord) {
        this.mEnglishWord = englishWord;
        this.mMiwokWord = miwokWord;
    }

    //  Getting the Default Translation of the word
    public String getEnglishTranslation() {
        return mEnglishWord;
    }

    //  Getting the Miwok Translation of the word
    public String getMiwokTranslation() {
        return mMiwokWord;
    }
}



















































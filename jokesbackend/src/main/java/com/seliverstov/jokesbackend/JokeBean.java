package com.seliverstov.jokesbackend;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private String mText;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
package com.scychina.demos;

import android.media.Image;

/**
 * Created by pengxu on 15-4-23.
 */
public class Video {
    private String filmName;
    private String filmTime;
    private int filmImage;
    private String price;
    private int countOfPeople;

    public Video(String _filmName, String _filmTime, int _filmImage, String Price, int countOfPeople) {
        super();
        this.filmImage = _filmImage;
        this.filmName = _filmName;
        this.filmTime = _filmTime;
        this.price = price;
        this.countOfPeople = countOfPeople;
    }

}

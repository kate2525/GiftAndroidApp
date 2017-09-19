package com.gmail.kovalenko.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kate on 16.09.2017.
 */

public class Data {
    @SerializedName("images")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

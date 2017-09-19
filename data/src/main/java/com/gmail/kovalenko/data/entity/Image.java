package com.gmail.kovalenko.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kate on 16.09.2017.
 */

public class Image {
    @SerializedName("fixed_height")
    private FixedHeight fixedHeight;

    public FixedHeight getFixedHeight() {
        return fixedHeight;
    }

    public void setFixedHeight(FixedHeight fixedHeight) {
        this.fixedHeight = fixedHeight;
    }
}

package com.gmail.kovalenko.data.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {
    @SerializedName("data")
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }
}

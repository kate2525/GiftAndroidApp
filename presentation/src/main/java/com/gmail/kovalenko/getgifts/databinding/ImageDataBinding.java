package com.gmail.kovalenko.getgifts.databinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by kate on 18.09.2017.
 */

public class ImageDataBinding {

    @BindingAdapter({"bind:src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}

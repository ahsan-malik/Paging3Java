package com.ahsanmalik.paging3java.appUtils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingAdapters {

    @BindingAdapter("loadImage")
    public static void setImage(ImageView imageView, String url){
        Glide.with(imageView).load(url).into(imageView);
    }

}

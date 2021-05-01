package com.ahsanmalik.paging3java.appUtils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.ahsanmalik.paging3java.R;
import com.bumptech.glide.Glide;

public class BindingAdapters {

    @BindingAdapter("loadImage")
    public static void setImage(ImageView imageView, String url){
        Glide.with(imageView)
                .load(url)
                .error(R.drawable.ic_twotone_error_24)
                .placeholder(R.drawable.ic_twotone_image_24)
                .into(imageView);
    }

}

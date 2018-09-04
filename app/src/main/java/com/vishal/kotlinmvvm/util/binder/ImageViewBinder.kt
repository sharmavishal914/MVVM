package com.vishal.kotlinmvvm.util.binder

import android.graphics.drawable.Drawable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide


@BindingAdapter("loadImage", "place")
fun setImageFormUrl(imageView: ImageView, imageUrl: String?, drawable: Drawable) {
    if (imageUrl == null) {
        imageView.setImageDrawable(drawable)
    } else {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView)
    }
}




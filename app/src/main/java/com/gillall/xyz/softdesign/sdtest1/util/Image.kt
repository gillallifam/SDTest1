package com.gillall.xyz.softdesign.sdtest1.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gillall.xyz.softdesign.sdtest1.R

object Image {
    fun imageFromURL(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url)
            .placeholder(R.drawable.defaultevent2)
            .apply(RequestOptions().override(763, 400))
            .into(imageView)
    }
}
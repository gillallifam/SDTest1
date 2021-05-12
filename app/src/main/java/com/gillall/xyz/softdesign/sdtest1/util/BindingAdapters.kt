package com.gillall.xyz.softdesign.sdtest1.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.gillall.xyz.softdesign.sdtest1.util.Image.imageFromURL

/**
 * Binding adapter used to display images from URL using Glide
 */
@BindingAdapter("imageUrl")
fun setImageURL(imageView: ImageView, url: String) {
    return imageFromURL(imageView, url)
}

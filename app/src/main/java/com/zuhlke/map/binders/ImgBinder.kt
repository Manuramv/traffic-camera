package com.zuhlke.map.binders

import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.zuhlke.map.R
import com.zuhlke.map.utils.DateParser


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).
        placeholder(R.drawable.img_loader).
        error(R.drawable.img_loader)
        .into(view)
}

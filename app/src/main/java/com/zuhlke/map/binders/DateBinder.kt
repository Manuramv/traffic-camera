package com.zuhlke.map.binders

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.zuhlke.map.utils.DateParser

@BindingAdapter("mytext")
fun mytext(view: TextView, date: String?) {
    view.setText("Picture taken at: "+ date?.let { DateParser.parseCameraDate(it) })
}
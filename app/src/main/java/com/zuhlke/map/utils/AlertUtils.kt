package com.zuhlke.map.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar

object AlertUtils {
    fun showSnackBar(view: View, message: String, action: String? = null,
                     actionListener: View.OnClickListener? = null ) {
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)

        if (action != null && actionListener!=null) {
            snackBar.setAction(action, actionListener)
        }
        snackBar.show()
    }
}
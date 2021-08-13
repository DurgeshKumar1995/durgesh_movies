package com.lowe.movies.common

import android.view.View
import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lowe.movies.R

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun ImageView.setImageUri(url:String?){
    load(url) {
        crossfade(true)
        placeholder(R.drawable.place_holder)
        error(R.drawable.place_holder)
        transformations(RoundedCornersTransformation(8f))
    }
}


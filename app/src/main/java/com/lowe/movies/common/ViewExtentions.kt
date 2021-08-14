package com.lowe.movies.common
/**
 * Extension functions
 */
import android.view.View
import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lowe.movies.R

/*
* this method hide the View from UI
* */
fun View.hide() {
    visibility = View.GONE
}

/*
* this method show the View from UI
* */
fun View.show() {
    visibility = View.VISIBLE
}

/*
* Set image from network with url
* @param url is @Nullable type value ,this param share network image url
* @param radius , add radius on image and default radius value is 8
* */
fun ImageView.setImageUri(url: String?, radius: Float = 8f) {
    load(url) {
        crossfade(true) // add crossfade in image
        placeholder(R.drawable.place_holder) // Add place holder on image
        error(R.drawable.place_holder) // If url not valid then show
        transformations(RoundedCornersTransformation(radius)) // add radius in image
    }
}

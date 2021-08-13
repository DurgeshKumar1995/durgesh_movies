package com.lowe.movies.dataSource

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Multimedia(
    val height: Int? = null,
    val src: String? = null,
    val type: String? = null,
    val width: Int? = null
):Parcelable
package com.lowe.movies.dataSource

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Link(
    val suggested_link_text: String? = null,
    val type: String? = null,
    val url: String? = null
):Parcelable
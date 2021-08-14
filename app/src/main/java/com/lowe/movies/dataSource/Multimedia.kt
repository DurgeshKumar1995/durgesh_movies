package com.lowe.movies.dataSource

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  multiple params.
 *  annotation @Parcelize , handle all stuff after implemented Parcelable
 *  after add @Parcelize no need add parcelable implementation
 *  Parcelable allow to share data via intent
 *
 * @param height image height returns
 * @param src image url
 * @param type image ratio ant tyoe
 * @param width image width
 */
@Parcelize
data class Multimedia(
    val height: Int? = null,
    val src: String? = null,
    val type: String? = null,
    val width: Int? = null
) : Parcelable

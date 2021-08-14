package com.lowe.movies.dataSource

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  multiple params.
 *  annotation @Parcelize , handle all stuff after implemented Parcelable
 *  after add @Parcelize no need add parcelable implementation
 *  Parcelable allow to share data via intent
 *
 * @param suggested_link_text hint of link
 * @param type url page type
 * @param url movie url
 */
@Parcelize
data class Link(
    val suggested_link_text: String? = null,
    val type: String? = null,
    val url: String? = null
) : Parcelable

package com.lowe.movies.dataSource

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  multiple params.
 *  annotation @Parcelize , handle all stuff after implemented Parcelable
 *  after add @Parcelize no need add parcelable implementation
 *  Parcelable allow to share data via intent
 *
 * @param byline movie byline
 * @param critics_pick critics count
 * @param date_updated movie updated date
 * @param display_title movie display title
 * @param headline movie headline
 * @param link Link object
 * @param mpaa_rating movie rating status
 * @param multimedia Multimedia object
 * @param opening_date movie opening date
 * @param publication_date movie publication date
 * @param summary_short movie short description
 */
@Parcelize
data class Result(
    val byline: String? = null,
    val critics_pick: Int? = null,
    val date_updated: String? = null,
    val display_title: String? = null,
    val headline: String? = null,
    val link: Link? = null,
    val mpaa_rating: String? = null,
    val multimedia: Multimedia? = null,
    val opening_date: String? = null,
    val publication_date: String? = null,
    val summary_short: String? = null
) : Parcelable

package com.lowe.movies.listener

/*
* Click listener interface with generic type
* T is generic type
* */
interface OnClickItem<T> {
    fun onClick(t: T? = null)
}

package com.lowe.movies.utils

import android.util.Log
import com.lowe.movies.BuildConfig

/*
* Print log on console
* if Build is debug
* */
object Logger {

    private const val TAG = "Logger"

    /*
    * print debug log if build is debug
    * @param msg , pass string for print in console
    * @param tag ,  string for log tag default value of is Logger
    * */
    fun debug(msg: String, tag: String ? = TAG) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg)
        }
    }

    /*
    * print debug log if build is debug
    * @param msg , pass string for print in console
    * @param tag ,  string for log tag default value of is Logger
    * */
    fun debug(msg: Exception?, tag: String = TAG) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg?.localizedMessage.toString())
        }
    }

}

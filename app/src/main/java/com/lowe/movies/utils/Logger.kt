package com.lowe.movies.utils

import android.util.Log
import com.lowe.movies.BuildConfig

object Logger {

    private const val TAG = "Logger"

    fun debug(msg:String,tag:String ?= TAG){
        if (BuildConfig.DEBUG){
            Log.d(tag,msg)
        }

    }
    fun debug( msg:Exception?,tag:String= TAG){
        if (BuildConfig.DEBUG){
            Log.d(tag,msg?.localizedMessage.toString())
        }
    }

    fun error( msg:String,tag:String= TAG){
        if (BuildConfig.DEBUG){
            Log.e(tag,msg)
        }
    }
    fun error( msg:Exception?,tag:String= TAG){
        if (BuildConfig.DEBUG){
            Log.e(tag,msg?.localizedMessage.toString())
        }
    }

}
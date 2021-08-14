package com.lowe.movies.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

/*
* Base class of View Model
* @param Application, Application context required for application context
* */
abstract class AndroidBaseViewModel(application: Application) : AndroidViewModel(application) {

    // Custom coroutine scope
    private val scope = CoroutineScope(
        Job() + Dispatchers.Main
    )

    // Cancel the job when the view model is destroyed
    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}

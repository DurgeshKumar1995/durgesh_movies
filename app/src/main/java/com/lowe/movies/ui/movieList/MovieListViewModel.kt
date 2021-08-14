package com.lowe.movies.ui.movieList

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lowe.movies.R
import com.lowe.movies.base.AndroidBaseViewModel
import com.lowe.movies.base.BaseApplication
import com.lowe.movies.common.ConstantString
import com.lowe.movies.dataSource.Result
import com.lowe.movies.repository.NetworkRepository
import com.lowe.movies.utils.Logger
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val networkRepository: NetworkRepository,
    application: Application
) : AndroidBaseViewModel(application) {

    private val _moviesList = MutableLiveData<ArrayList<Result>>()
    val moviesList: LiveData<ArrayList<Result>>
        get() = _moviesList

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private fun getMoviesListFromNetwork() {
        viewModelScope.launch {
            try {
                val networkResponse = networkRepository.getMoviesListAsync().await()
                Logger.debug(networkResponse.toString())
                if (networkResponse.status == ConstantString.OK && networkResponse.results?.isNotEmpty() == true) {
                    networkResponse.results.run(_moviesList::postValue)
                } else {
                    _status.postValue(getApplication<BaseApplication>().getString(R.string.no_record_found))
                }
            } catch (e: Exception) {
                Logger.debug(e)
                _status.postValue(e.message)
            }
        }
    }

    init {
        // Set initial state
        getMoviesListFromNetwork()
    }
}

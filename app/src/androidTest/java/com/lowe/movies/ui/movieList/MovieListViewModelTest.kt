package com.lowe.movies.ui.movieList

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.lowe.movies.base.BaseApplication
import com.lowe.movies.impl.FakeImpl
import com.lowe.movies.modules.NetworkModule
import com.lowe.movies.modules.ViewModelModules
import com.lowe.movies.repository.FakeNetworkRepository
import com.lowe.movies.repository.NetworkRepository
import com.lowe.movies.util.getOrAwaitValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.koin.core.KoinComponent
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.inject

@RunWith(AndroidJUnit4::class)
@LargeTest
class MovieListViewModelTest  :KoinComponent {

    val movieListViewModel:MovieListViewModel by inject()

    @Before
    fun setUp() {
//       stopKoin()
//        startKoin {
//            loadKoinModules(NetworkModule.networkModule)
//            loadKoinModules(ViewModelModules.viewModelsModule)
//        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun getMoviesList() {
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
//        val networkRepository = FakeImpl()
//        val model = FakeMovieListViewModel(networkRepository,appContext as Application)

        movieListViewModel.getMoviesListFromNetwork()
        movieListViewModel.viewModelScope.launch {
            delay(8000)
            val result = movieListViewModel.moviesList

            assertNotNull(result.value)
            assertNotNull(result.value?.get(0)?.headline)

        }
    }

    @Test
    fun getStatus() {
    }
}
package com.lowe.movies.ui.movieList

import androidx.lifecycle.viewModelScope
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.KoinComponent
import org.koin.core.context.stopKoin
import org.koin.core.inject

@RunWith(AndroidJUnit4::class)
@LargeTest
class MovieListViewModelTest : KoinComponent {

    val movieListViewModel: MovieListViewModel by inject()

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun getMoviesList() {

        movieListViewModel.getMoviesListFromNetwork()
        movieListViewModel.viewModelScope.launch {
            delay(8000)
            val result = movieListViewModel.moviesList

            assertNotNull(result.value)
            assertNotNull(result.value?.get(0)?.headline)
        }
    }
}

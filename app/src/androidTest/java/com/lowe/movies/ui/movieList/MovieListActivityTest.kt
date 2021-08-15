package com.lowe.movies.ui.movieList

import android.app.Instrumentation
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MovieListActivityTest {

    @Before
    fun setUp() {
        val mBrowserActivityMonitor = Instrumentation.ActivityMonitor(MovieListActivity::class.java.name, null, false)
        getInstrumentation().addMonitor(mBrowserActivityMonitor)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun onCreate() {
    }

    @Test
    fun onClick() {
    }
}

package com.lowe.movies.network

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NetworkUtilTest {

    /*
    * Network connectivity test
    * */
    @Test
    fun isInternetAvailable() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val isConnected = NetworkUtil.isInternetAvailable(appContext)

//        assertEquals(false,isConnected)// Test case when network connectivity off
        assertEquals(true, isConnected) // Test case when network connectivity On
    }
}

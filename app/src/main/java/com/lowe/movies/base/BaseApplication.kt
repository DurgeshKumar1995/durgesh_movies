package com.lowe.movies.base

import android.app.Application
import com.lowe.movies.modules.NetworkModule
import com.lowe.movies.modules.ViewModelModules
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin


/*
* used to simplify the sample. Consider a Dependency Injection(KOIN) framework.
*Setup for View models and network stuff
* Also, sets up application context and Logger.
*/
class BaseApplication : Application() {

    //App Entry point
    override fun onCreate() {
        super.onCreate()

        //Koin start
        startKoin {
            androidContext(this@BaseApplication) // add app context
            logger(AndroidLogger()) // Default Koin logger
            modules(NetworkModule.networkModule) // add network module
            modules(ViewModelModules.viewModelsModule) // add view models module

        }
    }
}

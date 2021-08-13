package com.lowe.movies.base

import android.app.Application
import com.lowe.movies.modules.NetworkModule
import com.lowe.movies.modules.ViewModelModules
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            logger(AndroidLogger())
            modules(NetworkModule.networkModule)
            modules(ViewModelModules.viewModelsModule)

            RxJavaPlugins.setErrorHandler {}
        }
    }
}

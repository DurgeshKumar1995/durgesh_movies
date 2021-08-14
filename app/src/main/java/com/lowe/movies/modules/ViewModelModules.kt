package com.lowe.movies.modules

import com.lowe.movies.impl.NetworkImpl
import com.lowe.movies.repository.NetworkRepository
import com.lowe.movies.ui.movieList.MovieListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Factory for all ViewModels and Repository.
 */
object ViewModelModules {

    /*
    * Add all view model and Repository
    * */
    val viewModelsModule: Module = module {
        /*
        * @param first set Network Repository with the help KOIN dependency
        * @param second set Application with the help KOIN dependency
        * */
        viewModel { MovieListViewModel(get(), androidApplication()) }

        /*
        * @param REST Api Repository with the help KOIN dependency
        * Initialize Network Repository
        * */
        single<NetworkRepository> { NetworkImpl(get()) }
    }
}

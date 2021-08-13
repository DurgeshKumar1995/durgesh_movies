package com.lowe.movies.modules

import com.lowe.movies.impl.NetworkImpl
import com.lowe.movies.repository.NetworkRepository
import com.lowe.movies.ui.movieList.MovieListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModules {



    val viewModelsModule : Module = module {
        viewModel { MovieListViewModel(get(),androidApplication()) }
        single<NetworkRepository> { NetworkImpl(get()) }

    }

}
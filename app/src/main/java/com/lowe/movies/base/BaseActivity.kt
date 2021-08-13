package com.lowe.movies.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseActivity<T : ViewModel>(clazz: KClass<T>) : AppCompatActivity() {

    val model: T by viewModel(clazz)

    val context: Context by lazy { this }
}

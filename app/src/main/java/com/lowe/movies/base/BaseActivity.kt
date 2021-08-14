package com.lowe.movies.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/*
* Parent activity of activity
* Add view model in activity
* model, view model instance
* context, Context instance
* */
abstract class BaseActivity<T : ViewModel>(clazz: KClass<T>) : AppCompatActivity() {

    //return View model instance
    val model: T by viewModel(clazz)

    //return Activity Context instance
    val context: Context by lazy { this }
}

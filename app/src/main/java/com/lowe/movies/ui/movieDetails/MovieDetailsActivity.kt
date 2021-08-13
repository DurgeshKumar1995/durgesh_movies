package com.lowe.movies.ui.movieDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lowe.movies.dataSource.Result
import com.lowe.movies.databinding.ActivityMovieDetailsBinding
import com.lowe.movies.utils.IntentKeyStrings
import org.jetbrains.anko.toast

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)

        intent?.run {
            if (hasExtra(IntentKeyStrings.shareMovieDataKey)) {
                val movieDetailModel: Result? =
                    getParcelableExtra(IntentKeyStrings.shareMovieDataKey)
                movieDetailModel?.run {
                    toast(this.toString())
                }
            }
        }
    }
}
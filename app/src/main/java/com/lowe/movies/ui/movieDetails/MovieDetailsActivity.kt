package com.lowe.movies.ui.movieDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lowe.movies.R
import com.lowe.movies.common.setImageUri
import com.lowe.movies.common.show
import com.lowe.movies.dataSource.Result
import com.lowe.movies.databinding.ActivityMovieDetailsBinding
import com.lowe.movies.utils.IntentKeyStrings
/*
* Get share selected Movie form movie list screen
* Set Movie Detail in UI
* */
class MovieDetailsActivity : AppCompatActivity() {

    /*
    * View Binding
    * */
    private lateinit var binding: ActivityMovieDetailsBinding

    /*
    * set Data in UI
    * set title and back button on screen
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val notApplicable = getString(R.string.n_a)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }

        intent?.run {
            if (hasExtra(IntentKeyStrings.shareMovieDataKey)) {
                val movieDetailModel: Result? =
                    getParcelableExtra(IntentKeyStrings.shareMovieDataKey)
                movieDetailModel?.run {
                    supportActionBar?.let {
                        it.title = display_title
                    }
                    binding.movieThumbnail.setImageUri(multimedia?.src, 0f)
                    binding.publicationDate.text = publication_date ?: notApplicable
                    binding.headLine.text = headline ?: notApplicable
                    binding.summaryShort.text = summary_short ?: notApplicable
                    link?.url?.let {
                        binding.linkURL.let { a ->
                            a.show()
                            a.text = it
                        }
                    }
                }
            }
        }
    }

    /*
    * Back button override method
    * */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

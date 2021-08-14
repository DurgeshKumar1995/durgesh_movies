package com.lowe.movies.ui.movieList

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lowe.movies.R
import com.lowe.movies.base.BaseActivity
import com.lowe.movies.dataSource.Result
import com.lowe.movies.databinding.ActivityMovieListBinding
import com.lowe.movies.listener.OnClickItem
import com.lowe.movies.ui.movieDetails.MovieDetailsActivity
import com.lowe.movies.ui.movieList.adapter.MovieListAdapter
import com.lowe.movies.utils.IntentKeyStrings
import org.jetbrains.anko.toast
/*
* Entry activity
* Set MovieListViewModel view model
* OnClickItem<Result> implemented for connection adapter and activity
* */
class MovieListActivity : BaseActivity<MovieListViewModel>(MovieListViewModel::class), OnClickItem<Result> {

    // Binding instance
    private lateinit var binding: ActivityMovieListBinding

    // Movie list Adapter initialize
    private val movieListAdapter = MovieListAdapter(this)

    /*
    * activity entry point
    * When activity start then firstly call this
    * It's call once in activity life cycle
    * Here initialize view and set data
    * live data observer initialize
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bind initialize
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set layout manager and adapter in recyclerview
        binding.root.run {
            layoutManager = LinearLayoutManager(this@MovieListActivity)
            adapter = movieListAdapter
        }

        // observe data from live data
        model.run {

            status.observe(
                this@MovieListActivity,
                {
                    it?.run {
                        toast(this)
                    }
                }
            )
            moviesList.observe(
                this@MovieListActivity,
                {
                    movieListAdapter.setData(it)
                }
            )
        }
    }

    /*
    * listener UI notifier
    * get data from list
    * @param t is Result type data
    * and start new Movie Detail activity
    * with the help intent and also share movie data in intent
    * */
    override fun onClick(t: Result?) {
        t?.run {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(IntentKeyStrings.shareMovieDataKey, this)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this@MovieListActivity,
                binding.root,
                getString(
                    R.string.thumbnail_share
                )
            )
            startActivity(intent, options.toBundle())
        }
    }
}

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

class MovieListActivity : BaseActivity<MovieListViewModel>(MovieListViewModel::class), OnClickItem<Result> {

    private lateinit var binding: ActivityMovieListBinding

    private val movieListAdapter = MovieListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.run {
            layoutManager = LinearLayoutManager(this@MovieListActivity)
            adapter = movieListAdapter
        }

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

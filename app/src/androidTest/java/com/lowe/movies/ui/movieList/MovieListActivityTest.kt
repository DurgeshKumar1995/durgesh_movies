package com.lowe.movies.ui.movieList

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.lowe.movies.R
import com.lowe.movies.databinding.ActivityMovieListBinding
import com.lowe.movies.ui.movieList.adapter.MovieListAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MovieListActivityTest {

    private lateinit var binding: ActivityMovieListBinding

    @get: Rule
    val activityRule = ActivityScenarioRule(MovieListActivity::class.java)

    @Before
    fun setUp() {
        activityRule.scenario.onActivity {
            binding = ActivityMovieListBinding.inflate(it.layoutInflater)
        }
    }
    /*
    * RecyclerView load in view
    * */
    @Test
    fun test_is_List_Activity_Visible_onAppLaunch() {
        onView(withId(R.id.movieList)).check(matches(isDisplayed()))
    }

    /*
    * Select movie list item from recyclerview, navigate to MovieDetailFragment
    * Correct movie is in view
    * */
    @Test
    fun test_selectListItem_isOnMovieDetailsActivity() {
        onView(withId(R.id.movieList))
            .perform(actionOnItemAtPosition<MovieListAdapter.MyViewHolder>(1, click()))

        onView(withId(R.id.headLine)).check(matches(withText("‘Days’ Review: A Taiwanese Auteur in a Quiet Mode")))
    }

    /*
    * select movie list item , navigate to MovieDetailAvtivity
    * pressBack
    * And verify pressBack worked or not
    * */
    @Test
    fun test_selectItem_onPressBack_toMovieDetailActivity() {
        onView(withId(R.id.movieList))
            .perform(actionOnItemAtPosition<MovieListAdapter.MyViewHolder>(1, click()))

        onView(withId(R.id.headLine)).check(matches(withText("‘Days’ Review: A Taiwanese Auteur in a Quiet Mode")))

        pressBack()

        onView(withId(R.id.movieList)).check(matches(isDisplayed()))
    }

    /*
    * RecyclerView Item scroll
    * */
    @Test
    fun testCaseForRecyclerScroll() {

        val recyclerView: RecyclerView = binding.movieList
        val itemCount = recyclerView.adapter?.itemCount ?: 0

        onView(withId(R.id.movieList)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemCount - 1))
    }

    @Test
    fun onCreate() {
        val scenario = launchActivity<MovieListActivity>()
        scenario.onActivity {
            binding = ActivityMovieListBinding.inflate(it.layoutInflater)
            Assert.assertNotNull(binding)
            Assert.assertNotNull(binding.movieList)

            it.lifecycleScope.launch {
                delay(5000)
                Assert.assertNotNull(binding.movieList.adapter)
                Assert.assertNotNull(binding.movieList.layoutManager)

                Assert.assertEquals(20, (binding.movieList.adapter as MovieListAdapter).itemCount)
                delay(5000)
            }
        }
    }

    @Test
    fun onClick() {

        onView(withId(R.id.movieList))
            .perform(actionOnItemAtPosition<MovieListAdapter.MyViewHolder>(1, click()))

        onView(withId(R.id.headLine)).check(matches(withText("‘Days’ Review: A Taiwanese Auteur in a Quiet Mode")))
    }
}

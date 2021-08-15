package com.lowe.movies.ui.movieDetails

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.google.gson.GsonBuilder
import com.lowe.movies.dataSource.Result
import com.lowe.movies.databinding.ActivityMovieDetailsBinding
import com.lowe.movies.utils.IntentKeyStrings
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MovieDetailsActivityTest {
    lateinit var activityScenario: ActivityScenario<MovieDetailsActivity>
    lateinit var movieModel: Result

    private lateinit var binding: ActivityMovieDetailsBinding

    private val movieModelString = "{\n" +
        "            \"display_title\": \"White as Snow\",\n" +
        "            \"mpaa_rating\": \"\",\n" +
        "            \"critics_pick\": 0,\n" +
        "            \"byline\": \"Lisa Kennedy\",\n" +
        "            \"headline\": \"‘White as Snow’ Review: The Fairest of Them All\",\n" +
        "            \"summary_short\": \"The director Anne Fontaine spins the Snow White fairy tale into a thriller, with Isabelle Huppert as the jealous stepmother.\",\n" +
        "            \"publication_date\": \"2021-08-12\",\n" +
        "            \"opening_date\": null,\n" +
        "            \"date_updated\": \"2021-08-12 15:14:03\",\n" +
        "            \"link\": {\n" +
        "                \"type\": \"article\",\n" +
        "                \"url\": \"https://www.nytimes.com/2021/08/12/movies/white-as-snow-review.html\",\n" +
        "                \"suggested_link_text\": \"Read the New York Times Review of White as Snow\"\n" +
        "            },\n" +
        "            \"multimedia\": {\n" +
        "                \"type\": \"mediumThreeByTwo210\",\n" +
        "                \"src\": \"https://static01.nyt.com/images/2021/08/12/arts/12white-as-snow1/12white-as-snow1-mediumThreeByTwo440.jpg\",\n" +
        "                \"height\": 140,\n" +
        "                \"width\": 210\n" +
        "            }\n" +
        "        }"

    @Before
    fun setUp() {
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        movieModel = gson.fromJson(movieModelString, Result::class.java)

        val intent =
            Intent(ApplicationProvider.getApplicationContext(), MovieDetailsActivity::class.java)
        intent.putExtra(
            IntentKeyStrings.shareMovieDataKey,
            movieModel
        ) // obviously use a const for key
        activityScenario = ActivityScenario.launch(intent)
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun onCreate() {

        activityScenario.onActivity {

            binding = ActivityMovieDetailsBinding.inflate(it.layoutInflater)
            assertNotNull(binding)
            assertNotNull(it.intent)
            val isIntentHaveData = it.intent.hasExtra(IntentKeyStrings.shareMovieDataKey)
            assertEquals(true, isIntentHaveData)
            val modelFromIntent =
                it.intent.getParcelableExtra<Result>(IntentKeyStrings.shareMovieDataKey)
            assertNotNull(modelFromIntent)

            it.lifecycleScope.launch {
                delay(2000)
                assertEquals(movieModel.headline, binding.headLine.text.toString())
            }
        }
    }

    @Test
    fun onSupportNavigateUp() {
        onView(withContentDescription("Navigate up")).perform(click())
    }
}

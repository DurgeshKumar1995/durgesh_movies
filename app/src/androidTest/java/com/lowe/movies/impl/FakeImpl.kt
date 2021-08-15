package com.lowe.movies.impl

import com.google.gson.GsonBuilder
import com.lowe.movies.dataSource.BaseModel
import com.lowe.movies.repository.FakeNetworkRepository
import kotlinx.coroutines.delay

/*
* Fake Network call impl of Network repository
* Add retrofit rest api interface
* @param restApi restApi for retrofit interface instance
 */
class FakeImpl() : FakeNetworkRepository {

    /*
    * NetworkRepository implemented function
     * @return network response with Deferred
     */
    override suspend fun getMoviesListAsync(): BaseModel {
        delay(1000)
        val resultModelDataString = "{\n" +
            "    \"status\": \"OK\",\n" +
            "    \"copyright\": \"Copyright (c) 2021 The New York Times Company. All Rights Reserved.\",\n" +
            "    \"has_more\": true,\n" +
            "    \"num_results\": 20,\n" +
            "    \"results\": [\n" +
            "        {\n" +
            "            \"display_title\": \"The Lost Leonardo\",\n" +
            "            \"mpaa_rating\": \"PG-13\",\n" +
            "            \"critics_pick\": 1,\n" +
            "            \"byline\": \"Glenn Kenny\",\n" +
            "            \"headline\": \"‘The Lost Leonardo’ Review: Art, Money and Oligarchy\",\n" +
            "            \"summary_short\": \"This documentary about the painting “Salvator Mundi” packs the fascination and wallop of an expertly executed fictional thriller.\",\n" +
            "            \"publication_date\": \"2021-08-12\",\n" +
            "            \"opening_date\": \"2021-08-13\",\n" +
            "            \"date_updated\": \"2021-08-12 11:02:02\",\n" +
            "            \"link\": {\n" +
            "                \"type\": \"article\",\n" +
            "                \"url\": \"https://www.nytimes.com/2021/08/12/movies/the-lost-leonardo-review.html\",\n" +
            "                \"suggested_link_text\": \"Read the New York Times Review of The Lost Leonardo\"\n" +
            "            },\n" +
            "            \"multimedia\": {\n" +
            "                \"type\": \"mediumThreeByTwo210\",\n" +
            "                \"src\": \"https://static01.nyt.com/images/2021/08/12/arts/12lostleonardo/12lostleonardo-mediumThreeByTwo440.jpg\",\n" +
            "                \"height\": 140,\n" +
            "                \"width\": 210\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}"

        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()

        val resultModel = gson.fromJson(resultModelDataString, BaseModel::class.java)
        return resultModel
    }
}

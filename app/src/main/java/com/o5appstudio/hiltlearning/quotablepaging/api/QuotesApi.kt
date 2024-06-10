package com.o5appstudio.hiltlearning.quotablepaging.api

import com.o5appstudio.hiltlearning.quotablepaging.model.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page : Int) : QuoteList
}
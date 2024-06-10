package com.o5appstudio.hiltlearning.quotablepaging.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.o5appstudio.hiltlearning.quotablepaging.QuoteDatabase
import com.o5appstudio.hiltlearning.quotablepaging.api.QuotesApi
import com.o5appstudio.hiltlearning.quotablepaging.paging.QuotePagingSource
import com.o5appstudio.hiltlearning.quotablepaging.paging.QuoteRemoteMediator
import javax.inject.Inject

class QuoteRepo @Inject constructor(private val quotesApi: QuotesApi, private val quoteDatabase: QuoteDatabase) {

    @OptIn(ExperimentalPagingApi::class)
    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
//        pagingSourceFactory = {QuotePagingSource(quotesApi)}
        remoteMediator = QuoteRemoteMediator(quotesApi,quoteDatabase),
                pagingSourceFactory = {quoteDatabase.quotesDao().getQuotes()}
    ).liveData
}
package com.o5appstudio.hiltlearning.quotablepaging.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.o5appstudio.hiltlearning.quotablepaging.QuoteDatabase
import com.o5appstudio.hiltlearning.quotablepaging.api.QuotesApi
import com.o5appstudio.hiltlearning.quotablepaging.model.QuoteRemoteKeys
import com.o5appstudio.hiltlearning.quotablepaging.model.Result

@OptIn(ExperimentalPagingApi::class)
class QuoteRemoteMediator(
    private val quotesApi: QuotesApi,
    private val quoteDatabase: QuoteDatabase
) : RemoteMediator<Int, Result>() {

    val quotesDao = quoteDatabase.quotesDao()
    val quoteRemoteKeysDao = quoteDatabase.remoteKeysDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Result>): MediatorResult {
        // Fetch quotes from API
        // Save these Quotes in DB + Remote Keys Data in DB
        //Logic for states = REFRESH, PREPEND, APPEND

        return try {
            val currentPage = when(loadType){
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
            val response = quotesApi.getQuotes(currentPage)
            val endOfPaginationReached = response.totalPages ==  currentPage

            val prevPage  = if(currentPage == 1) null else currentPage -1
            val nextPage = if(endOfPaginationReached) null else currentPage +1

            quoteDatabase.withTransaction {

                if (loadType == LoadType.REFRESH) {
                    quotesDao.deleteQuotes()
                    quoteRemoteKeysDao.deleteAllRemoteKeys()
                }

                quotesDao.addQuotes(response.results)

                val keys = response.results.map {quote ->
                    QuoteRemoteKeys(
                        id = quote._id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                quoteRemoteKeysDao.addAllRemoteKeys(keys)

            }
            MediatorResult.Success(endOfPaginationReached)

        } catch (e : Exception){
            MediatorResult.Error(e)
        }
    }

    private fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Result>
    ): QuoteRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?._id?.let { id ->
                quoteRemoteKeysDao.getRemoteKeys(id = id)
            }
        }
    }

    private fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Result>
    ): QuoteRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { quote ->
                quoteRemoteKeysDao.getRemoteKeys(id = quote._id)
            }
    }

    private fun getRemoteKeyForLastItem(
        state: PagingState<Int, Result>
    ): QuoteRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { quote ->
                quoteRemoteKeysDao.getRemoteKeys(id = quote._id)
            }
    }

}
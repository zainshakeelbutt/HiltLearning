package com.o5appstudio.hiltlearning.quotablepaging.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.o5appstudio.hiltlearning.quotablepaging.model.QuoteList
import com.o5appstudio.hiltlearning.quotablepaging.model.Result
import javax.inject.Inject

@Dao
interface QuotesDao {
    @Query("Select * from quotes")
    fun getQuotes() : PagingSource<Int,Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotes(quotes : List<Result>)

    @Query("Delete From quotes")
    suspend fun deleteQuotes()
}
package com.o5appstudio.hiltlearning.quotablepaging.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.o5appstudio.hiltlearning.quotablepaging.model.QuoteRemoteKeys
import com.o5appstudio.hiltlearning.quotablepaging.model.Result

@Dao
interface RemoteKeysDao {
    @Query("Select * from QuoteRemoteKeys WHERE id =:id")
    fun getRemoteKeys(id:String) : QuoteRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<QuoteRemoteKeys>)

    @Query("Delete From QuoteRemoteKeys")
    suspend fun deleteAllRemoteKeys()
}
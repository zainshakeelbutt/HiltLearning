package com.o5appstudio.hiltlearning.quotablepaging

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.o5appstudio.hiltlearning.quotablepaging.db.QuotesDao
import com.o5appstudio.hiltlearning.quotablepaging.db.RemoteKeysDao
import com.o5appstudio.hiltlearning.quotablepaging.model.QuoteRemoteKeys
import com.o5appstudio.hiltlearning.quotablepaging.model.Result

@Database(entities = [Result::class, QuoteRemoteKeys::class], version = 1)
abstract class QuoteDatabase : RoomDatabase(){

    abstract fun quotesDao() : QuotesDao
    abstract fun remoteKeysDao() : RemoteKeysDao

}
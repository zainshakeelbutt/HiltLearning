package com.o5appstudio.hiltlearning.quotablepaging.di

import android.content.Context
import androidx.room.Room
import com.o5appstudio.hiltlearning.quotablepaging.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase (@ApplicationContext context: Context) : QuoteDatabase {
        return Room.databaseBuilder(context, QuoteDatabase::class.java,"QuoteDb").build()
    }


}
package com.o5appstudio.hiltlearning.quotablepaging.di

import com.o5appstudio.hiltlearning.quotablepaging.api.QuotesApi
import com.o5appstudio.hiltlearning.quotablepaging.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun providesQuotesApi(retrofit: Retrofit) : QuotesApi{
        return  retrofit.create(QuotesApi::class.java)
    }

}
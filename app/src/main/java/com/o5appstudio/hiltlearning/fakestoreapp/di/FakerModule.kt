//package com.o5appstudio.hiltlearning.fakestoreapp.di
//
//import com.o5appstudio.hiltlearning.fakestoreapp.api.FakerApi
//import com.o5appstudio.hiltlearning.fakestoreapp.constants.Constants
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//@InstallIn(SingletonComponent::class)
//@Module
//class FakerModule {
//
//    @Singleton
//    @Provides
//    fun providesRetrofit() : Retrofit{
//        return  Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun providesApi(retrofit: Retrofit) : FakerApi{
//        return retrofit.create(FakerApi::class.java)
//    }
//
//}
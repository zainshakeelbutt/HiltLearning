//package com.o5appstudio.hiltlearning.fakestoreapp.di
//
//import android.content.Context
//import androidx.room.Room
//import com.o5appstudio.hiltlearning.fakestoreapp.db.FakerDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@InstallIn(SingletonComponent::class)
//@Module
//class FakerDbModule {
//
//    @Singleton
//    @Provides
//    fun providesFakerDb(@ApplicationContext context: Context) : FakerDatabase{
//        return  Room.databaseBuilder(context, FakerDatabase::class.java, "FakerDatabase").build()
//    }
//
//}
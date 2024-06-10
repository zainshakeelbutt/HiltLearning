package com.o5appstudio.hiltlearning.concepts

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@InstallIn(ActivityComponent::class)
@Module
class UserModule {

    @Provides
    @Named("sql")
    fun providesSQLRepository(sqlUserSaveRepo: SQLUserSaveRepo) : SaveUserRepository {
        return sqlUserSaveRepo
    }

    @Provides
    @Named("firebase")
    fun providesFirebaseRepository() : SaveUserRepository {
        return FirebaseUserSaveRepo()
    }
}
package com.o5appstudio.hiltlearning

import android.app.Application
import com.o5appstudio.hiltlearning.concepts.UserRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class UserApplication : Application() {

//    @Inject
//    lateinit var userRepository: UserRepository

    override fun onCreate() {
        super.onCreate()

//        userRepository.saveUser("zain@gmail.com","123456")

    }
}
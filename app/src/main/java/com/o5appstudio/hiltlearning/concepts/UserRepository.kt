package com.o5appstudio.hiltlearning.concepts

import android.util.Log
import javax.inject.Inject

const val TAG = "HILTAPP"

class UserRepository @Inject constructor(private val loggerService: LoggerService) {
    fun saveUser(email:String, password:String){
        loggerService.log("User saved in db")

    }
}
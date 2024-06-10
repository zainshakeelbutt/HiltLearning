package com.o5appstudio.hiltlearning.concepts

import android.util.Log
import javax.inject.Inject

interface SaveUserRepository {
    fun saveUser(email:String, password:String)
}

class SQLUserSaveRepo @Inject constructor () : SaveUserRepository{
    override fun saveUser(email: String, password: String) {
       Log.d(TAG,"User Saved in SQL Repo")
    }
}

class FirebaseUserSaveRepo : SaveUserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d(TAG,"User Saved in Firebase Repo")
    }
}
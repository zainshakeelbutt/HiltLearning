package com.o5appstudio.hiltlearning.concepts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.o5appstudio.hiltlearning.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    @Named("firebase")
    lateinit var saveUserRepository: SaveUserRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        saveUserRepository.saveUser("zain@gmail.com","123456")

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}
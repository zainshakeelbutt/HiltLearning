package com.o5appstudio.hiltlearning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.o5appstudio.hiltlearning.quotablepaging.paging.LoaderAdapter

import com.o5appstudio.hiltlearning.quotablepaging.paging.QuotePagingAdapter
import com.o5appstudio.hiltlearning.quotablepaging.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var userRepository: UserRepository

//    private lateinit var mainViewModel: FakerViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuotePagingAdapter
    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotable_main)
//        userRepository.saveUser("zain@gmail.com","123456")

        recyclerView = findViewById(R.id.quoteList)
        adapter = QuotePagingAdapter()
        quoteViewModel = ViewModelProvider.create(this)[QuoteViewModel::class.java]
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(),
            footer = LoaderAdapter()
        )

        quoteViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle,it)
        })


//        mainViewModel = ViewModelProvider.create(this)[FakerViewModel::class.java]
//        mainViewModel.productsList.observe(this, Observer { value ->
//            value.forEach(){
//                Log.d(TAG,it.title)
//            }
//        })





    }
}
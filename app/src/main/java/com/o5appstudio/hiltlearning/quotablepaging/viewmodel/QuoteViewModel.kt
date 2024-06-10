package com.o5appstudio.hiltlearning.quotablepaging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import com.o5appstudio.hiltlearning.quotablepaging.repository.QuoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class QuoteViewModel @Inject constructor(private val quoteRepo: QuoteRepo) : ViewModel() {

    val list = quoteRepo.getQuotes().cachedIn(viewModelScope)
}
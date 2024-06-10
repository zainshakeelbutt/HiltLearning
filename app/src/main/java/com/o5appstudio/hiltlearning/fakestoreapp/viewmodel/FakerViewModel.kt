//package com.o5appstudio.hiltlearning.fakestoreapp.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.o5appstudio.hiltlearning.fakestoreapp.model.Products
//import com.o5appstudio.hiltlearning.fakestoreapp.repository.ProductsRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class FakerViewModel @Inject constructor (private val repository: ProductsRepository) : ViewModel() {
//
//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.getProducts()
//        }
//    }
//
//    val productsList : LiveData<List<Products>>
//    get() = repository.productsData
//
//}
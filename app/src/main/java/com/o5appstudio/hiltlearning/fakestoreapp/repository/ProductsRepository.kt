//package com.o5appstudio.hiltlearning.fakestoreapp.repository
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.o5appstudio.hiltlearning.fakestoreapp.model.Products
//import com.o5appstudio.hiltlearning.fakestoreapp.api.FakerApi
//import com.o5appstudio.hiltlearning.fakestoreapp.db.FakerDatabase
//import javax.inject.Inject
//
//class ProductsRepository @Inject constructor(private val fakerApi: FakerApi, private val fakerDatabase: FakerDatabase) {
//
//    private val productsLiveData =  MutableLiveData<List<Products>>()
//    val productsData : LiveData<List<Products>>
//        get() = productsLiveData
//
//    suspend fun getProducts(){
//        val result = fakerApi.getProducts()
//        if (result.isSuccessful && result.body() != null){
//            fakerDatabase.getDao().deleteAllProducts()
//            fakerDatabase.getDao().addProducts(result.body()!!)
//            productsLiveData.postValue(result.body())
//        }
//    }
//
//}
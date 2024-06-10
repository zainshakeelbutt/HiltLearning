//package com.o5appstudio.hiltlearning.fakestoreapp.db
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.o5appstudio.hiltlearning.fakestoreapp.model.Products
//
//@Dao
//interface FakerDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addProducts(products: List<Products>)
//
//    @Query("Select * from Products")
//    suspend fun getProducts() : List<Products>
//
//    @Query("Delete from products")
//    suspend fun deleteAllProducts()
//}
package com.miguel.shopapp.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.miguel.shopapp.data.local.entities.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM Product ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<Product>>
    @Insert suspend fun insert(product: Product): Long
    @Update suspend fun update(product: Product)
    @Delete suspend fun delete(product: Product)
    @Query("SELECT * FROM Product WHERE id=:id") suspend fun get(id: Long): Product?
}

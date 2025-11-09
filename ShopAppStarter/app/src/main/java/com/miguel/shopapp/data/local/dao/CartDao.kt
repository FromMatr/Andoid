package com.miguel.shopapp.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.miguel.shopapp.data.local.entities.CartItem

@Dao
interface CartDao {
    @Query("SELECT * FROM CartItem") fun observeCart(): Flow<List<CartItem>>
    @Insert suspend fun add(item: CartItem): Long
    @Update suspend fun update(item: CartItem)
    @Delete suspend fun remove(item: CartItem)
    @Query("DELETE FROM CartItem") suspend fun clear()
}

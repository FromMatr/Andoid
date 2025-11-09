package com.miguel.shopapp.data.repo

import com.miguel.shopapp.data.local.dao.CartDao

class CartRepository(private val cartDao: CartDao) {
    fun cart() = cartDao.observeCart()
    suspend fun clear() = cartDao.clear()
}

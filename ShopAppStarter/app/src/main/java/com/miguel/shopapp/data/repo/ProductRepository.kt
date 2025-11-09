package com.miguel.shopapp.data.repo

import com.miguel.shopapp.data.local.dao.ProductDao
import com.miguel.shopapp.data.local.entities.Product

class ProductRepository(private val dao: ProductDao) {
    fun products() = dao.observeAll()
    suspend fun create(p: Product) = dao.insert(p)
    suspend fun update(p: Product) = dao.update(p)
    suspend fun delete(p: Product) = dao.delete(p)
}

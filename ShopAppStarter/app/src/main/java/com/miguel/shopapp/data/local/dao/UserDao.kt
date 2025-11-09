package com.miguel.shopapp.data.local.dao

import androidx.room.*
import com.miguel.shopapp.data.local.entities.User

@Dao
interface UserDao {
    @Insert suspend fun insert(user: User): Long
    @Query("SELECT * FROM User WHERE email=:email LIMIT 1")
    suspend fun findByEmail(email: String): User?
}

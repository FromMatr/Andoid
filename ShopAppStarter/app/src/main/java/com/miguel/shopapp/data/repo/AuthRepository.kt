package com.miguel.shopapp.data.repo

import com.miguel.shopapp.data.local.dao.UserDao
import com.miguel.shopapp.data.local.entities.User
import com.miguel.shopapp.data.prefs.SessionDataStore

class AuthRepository(private val userDao: UserDao, private val session: SessionDataStore) {
    suspend fun register(name: String, email: String, pass: String): Result<Long> {
        require(pass.length >= 8) { "Contraseña débil" }
        if (userDao.findByEmail(email) != null) return Result.failure(Exception("Email ya registrado"))
        val id = userDao.insert(User(name = name, email = email, passwordHash = hash(pass)))
        session.login(id); return Result.success(id)
    }
    suspend fun login(email: String, pass: String): Result<Long> {
        val u = userDao.findByEmail(email) ?: return Result.failure(Exception("Credenciales inválidas"))
        return if (u.passwordHash == hash(pass)) { session.login(u.id); Result.success(u.id) }
               else Result.failure(Exception("Credenciales inválidas"))
    }
    private fun hash(raw: String) = raw.hashCode().toString() // Reemplazar por BCrypt/SHA-256
}

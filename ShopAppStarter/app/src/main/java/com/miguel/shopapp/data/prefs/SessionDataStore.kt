package com.miguel.shopapp.data.prefs

import android.content.Context
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

private val Context.dataStore by preferencesDataStore("session_prefs")

class SessionDataStore(private val ctx: Context) {
    companion object { val KEY_USER = longPreferencesKey("logged_user_id") }

    val loggedUserId: Flow<Long?> = ctx.dataStore.data.map { it[KEY_USER] }

    suspend fun login(userId: Long) { ctx.dataStore.edit { it[KEY_USER] = userId } }
    suspend fun logout() { ctx.dataStore.edit { it.remove(KEY_USER) } }
}

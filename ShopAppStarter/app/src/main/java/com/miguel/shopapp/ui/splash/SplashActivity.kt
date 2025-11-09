package com.miguel.shopapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miguel.shopapp.ui.welcome.WelcomeActivity
import com.miguel.shopapp.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // En un caso real, chequear sesión (DataStore) y decidir a dónde ir
        startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }
}

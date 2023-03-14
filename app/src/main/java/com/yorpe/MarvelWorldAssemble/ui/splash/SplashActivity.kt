package com.yorpe.MarvelWorldAssemble.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.yorpe.MarvelWorldAssemble.databinding.ActivitySplashBinding
import com.yorpe.MarvelWorldAssemble.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Glide.with(this.applicationContext).load(R.drawable.loading).into(binding.imageView)
//        Picasso.get().load("https://usagif.com/wp-content/uploads/loading-37.gif").into(binding.imageView)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
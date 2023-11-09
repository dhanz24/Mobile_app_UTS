package com.example.healthybudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.healthybudy.databinding.ActivitySplashPageBinding

class splash_page : AppCompatActivity() {
    private lateinit var binding: ActivitySplashPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logoIntro.alpha = 0f

        binding.logoIntro.animate().setDuration(1500).alpha(1f).withEndAction{
            val i = Intent(this, start_page::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            finish()
        }

    }
}
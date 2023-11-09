package com.example.healthybudy

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button_start : com.google.android.material.button.MaterialButton = findViewById(R.id.button_login)

        button_start.setOnClickListener{
            val  intent = Intent(this,menu_navbar::class.java)
            startActivity(intent)
        }
    }
}
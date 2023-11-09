package com.example.healthybudy

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log


class start_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        val button_start : com.google.android.material.button.MaterialButton = findViewById(R.id.button_start)

        button_start.setOnClickListener{
            val  intent = Intent(this,register::class.java)
            startActivity(intent)
        }

        val button_reg : TextView = findViewById(R.id.login_start)
        button_reg.setOnClickListener{
            val  intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}
package com.example.healthybudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button_sign : com.google.android.material.button.MaterialButton = findViewById(R.id.button_sign)

        button_sign.setOnClickListener{
            val  intent = Intent(this,menu_navbar::class.java)
            startActivity(intent)
        }

        val button_reg : TextView = findViewById(R.id.login_start)
        button_reg.setOnClickListener{
            val  intent = Intent(this, login::class.java)
            startActivity(intent)
        }

    }
}
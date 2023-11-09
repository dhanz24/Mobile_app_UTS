package com.example.healthybudy

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class konversi_suhu : AppCompatActivity() {
    private lateinit var edit1: EditText
    private lateinit var edit2: EditText
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var hitungButton: Button
    private lateinit var layoutFormula: TextView
    private lateinit var textFormula: TextView

    private val temperatures = arrayOf(
        "\u00B0C",
        "\u00B0R",
        "\u00B0F",
        "K"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konversi_suhu)

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)
        hitungButton = findViewById(R.id.hitung)
        layoutFormula = findViewById(R.id.layout_formula)
        textFormula = findViewById(R.id.text_formula)

        // Inisialisasi adapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, temperatures)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Atur adapter ke Spinner
        spinner1.adapter = adapter
        spinner2.adapter = adapter

        hitungButton.setOnClickListener {
            hitungKonversiSuhu()
        }
    }

    private fun hitungKonversiSuhu() {
        // Your existing conversion logic goes here
    }
}
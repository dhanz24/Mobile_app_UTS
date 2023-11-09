package com.example.healthybudy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class bmi : AppCompatActivity() {

    private var editTextWeight: EditText? = null
    private var editTextHeight: EditText? = null
    private var buttonCalculateBMI: Button? = null
    private var textViewBMIResult: TextView? = null
    private var textViewIdealWeight: TextView? = null
    private var textViewFatPercentage: TextView? = null
    private var textViewBMIClassification: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        editTextWeight = findViewById<EditText>(R.id.weightInput)
        editTextHeight = findViewById<EditText>(R.id.heightInput)
        textViewBMIResult = findViewById<TextView>(R.id.bmiResult)
        textViewIdealWeight = findViewById<TextView>(R.id.idealWeight)
        textViewFatPercentage = findViewById<TextView>(R.id.fatPercentage)
        textViewBMIClassification = findViewById<TextView>(R.id.bmiClassification)
        buttonCalculateBMI = findViewById<Button>(R.id.calculateButton)

        buttonCalculateBMI!!.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        try {
            val weight = editTextWeight!!.text.toString().toDouble()
            val heightInCm = editTextHeight!!.text.toString().toDouble()

            // Konversi tinggi dari cm ke meter
            val heightInMeter = heightInCm / 100

            // Hitung BMI
            val bmi = weight / (heightInMeter * heightInMeter)

            // Calculate Ideal Weight, Fat Percentage, and BMI Classification
            val idealWeight = 22.0 * (heightInMeter * heightInMeter)
            val fatPercentage = (1.2 * bmi) + (0.23 * 25) - 5.4
            val classification = when {
                bmi < 18.5 -> "Underweight"
                bmi >= 18.5 && bmi < 24.9 -> "Normal weight"
                bmi >= 25 && bmi < 29.9 -> "Overweight"
                else -> "Obese"
            }

            // Format hasil dan tampilkan pada TextViews
            textViewBMIResult!!.text = String.format("Your BMI is %.2f", bmi)
            textViewIdealWeight!!.text = String.format("Ideal Weight: %.2f kg", idealWeight)
            textViewFatPercentage!!.text = String.format("Fat Percentage: %.2f", fatPercentage)
            textViewBMIClassification!!.text = "BMI Classification: $classification"

        } catch (e: NumberFormatException) {
            textViewBMIResult!!.text = "Invalid input"
        }
    }
}

package com.example.healthybudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.healthybudy.databinding.ActivityKalkulatorBinding
import javax.xml.xpath.XPathExpression
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class kalkulator : AppCompatActivity() {

    private lateinit var binding: ActivityKalkulatorBinding
    var lastNumeric = false
    var stateError = false
    var lastDot = false

    private lateinit var expression:Expression


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKalkulatorBinding.inflate(layoutInflater)
        // Inisialisasi expression
        expression = ExpressionBuilder("0").build()

        setContentView(binding.root)
        binding.btn1.setOnClickListener { onDigitClick(binding.btn1) }
        binding.btn2.setOnClickListener { onDigitClick(binding.btn2) }
        binding.btn3.setOnClickListener { onDigitClick(binding.btn3) }
        binding.btn4.setOnClickListener { onDigitClick(binding.btn4) }
        binding.btn5.setOnClickListener { onDigitClick(binding.btn5) }
        binding.btn6.setOnClickListener { onDigitClick(binding.btn6) }
        binding.btn7.setOnClickListener { onDigitClick(binding.btn7) }
        binding.btn8.setOnClickListener { onDigitClick(binding.btn8) }
        binding.btn9.setOnClickListener { onDigitClick(binding.btn9) }
        binding.btn0.setOnClickListener { onDigitClick(binding.btn0) }
        binding.btnPlus.setOnClickListener { onOperatorClick(binding.btnPlus) }
        binding.btnMin.setOnClickListener { onOperatorClick(binding.btnMin) }
        binding.btnMul.setOnClickListener { onOperatorClick(binding.btnMul) }
        binding.btnDiv.setOnClickListener { onOperatorClick(binding.btnDiv) }

        binding.btnAc.setOnClickListener { onAllClearClick() }
        binding.btnBack.setOnClickListener { onBackClick() }
        binding.btnPercent.setOnClickListener { onOperatorClick(binding.btnPercent) }

        binding.btnEqual.setOnClickListener { onEqualClick() }
        binding.btnDot.setOnClickListener { onDigitClick(binding.btnDot) }

    }

    fun onAllClearClick() {
        binding.dataTv.text = ""
        binding.resultTv.text = ""
        stateError = false
        lastDot = false
        lastNumeric = false
        binding.resultTv.visibility = View.GONE
    }

    fun onBackClick() {
        binding.dataTv.text = binding.dataTv.text.toString().dropLast(1)
        try {
            val lastChar = binding.dataTv.text.toString().last()
            if (lastChar.isDigit()) {
                onEqual()
            }
        } catch (e: Exception) {
            binding.resultTv.text = ""
            binding.resultTv.visibility = View.GONE
            Log.e("last char error", e.toString())
        }
    }
    fun onOperatorClick(view: View) {
        if (!stateError && lastNumeric) {
            binding.dataTv.append((view as Button).text)
            lastDot = false
            lastNumeric = false
            onEqual()
        }
    }

    fun onDigitClick(view: View) {
        if (stateError) {
            binding.dataTv.text = (view as Button).text
            stateError = false
        } else {
            binding.dataTv.append((view as Button).text)
        }
        lastNumeric = true
    }

    fun onEqualClick() {
        onEqual()
        binding.dataTv.text = binding.resultTv.text.toString().drop(1)
    }
    private fun onEqual(){
        if (lastNumeric && !stateError) {
            val txt = binding.dataTv.text.toString().trim()

            if (txt.isNotEmpty()) {
                expression = ExpressionBuilder(txt).build()

                try {
                    val result = expression.evaluate()
                    binding.resultTv.visibility = View.VISIBLE
                    binding.resultTv.text = "=$result"
                } catch (ex: ArithmeticException) {
                    Log.e("evaluate error", ex.toString())
                    binding.resultTv.text = "Error"
                    stateError = true
                    lastNumeric = true
                }
            } else {
                binding.resultTv.text = ""
                binding.resultTv.visibility = View.GONE
            }
        }
    }
}
package com.example.vucutktleindeksapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun calculateBMI(view: View) {
        val height = heightEditText.text.toString().toDoubleOrNull()
        val weight = weightEditText.text.toString().toDoubleOrNull()

        if (height == null || weight == null) {
            resultTextView.text = "Lütfen geçerli bir boy ve kilo girin."
            return
        }

        val bmi = weight / (height * height)

        val bmiCategory = when {
            bmi < 18.5 -> "Zayıf"
            bmi < 24.9 -> "Normal"
            bmi < 29.9 -> "Kilolu"
            else -> "Obez"
        }

        val df = DecimalFormat("#.##")
        resultTextView.text = "BMI: ${df.format(bmi)}, Durum: $bmiCategory"
    }
}

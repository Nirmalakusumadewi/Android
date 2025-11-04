package com.mala.utsandroid

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Atur padding otomatis (kode default)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil komponen dari layout
        val inputCelcius = findViewById<EditText>(R.id.inputCelcius)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        // Aksi tombol konversi
        btnConvert.setOnClickListener {
            val celsiusText = inputCelcius.text.toString()

            if (celsiusText.isNotEmpty()) {
                val celsius = celsiusText.toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32
                txtResult.text = "Hasil: %.2f °F".format(fahrenheit)
            } else {
                Toast.makeText(this, "Masukkan suhu dalam °C", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

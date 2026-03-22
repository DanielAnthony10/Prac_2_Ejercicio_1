package com.example.prac_2_ejercicio_1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextCantidad: EditText

    private lateinit var radioDolares: RadioButton
    private lateinit var radioSoles: RadioButton
    private lateinit var radioEuro: RadioButton
    private lateinit var radioLibra: RadioButton
    private lateinit var radioRupia: RadioButton
    private lateinit var radioReal: RadioButton
    private lateinit var radioPeso: RadioButton
    private lateinit var radioYuan: RadioButton
    private lateinit var radioYen: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCantidad = findViewById(R.id.editTextCantidad)

        radioDolares = findViewById(R.id.radioDolares)
        radioSoles = findViewById(R.id.radioSoles)
        radioEuro = findViewById(R.id.radioEuro)
        radioLibra = findViewById(R.id.radioLibra)
        radioRupia = findViewById(R.id.radioRupia)
        radioReal = findViewById(R.id.radioReal)
        radioPeso = findViewById(R.id.radioPeso)
        radioYuan = findViewById(R.id.radioYuan)
        radioYen = findViewById(R.id.radioYen)
    }

    fun miClicManejador(view: View) {

        val texto = editTextCantidad.text.toString().trim()

        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show()
            return
        }

        val cantidad = texto.toFloatOrNull()

        if (cantidad == null || cantidad <= 0) {
            Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
            return
        }

        val resultado = when {
            radioDolares.isChecked -> cantidad * 3.45f
            radioSoles.isChecked -> cantidad / 3.45f
            radioEuro.isChecked -> cantidad * 1.08f
            radioLibra.isChecked -> cantidad * 1.25f
            radioRupia.isChecked -> cantidad * 0.012f
            radioReal.isChecked -> cantidad * 0.20f
            radioPeso.isChecked -> cantidad * 0.058f
            radioYuan.isChecked -> cantidad * 0.14f
            radioYen.isChecked -> cantidad * 0.0067f
            else -> 0f
        }

        Toast.makeText(this, "Resultado: ${"%.2f".format(resultado)}", Toast.LENGTH_LONG).show()
    }
}
package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textView_result)
        val tvClassicacao = findViewById<TextView>(R.id.textView_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

    /*  Tabela IMC
        Menor que 18,5 = abaixo do peso
        Entre 18,5 e 24,9 = normal
        Entre 25,0 e 29,9 = sobrepeso
        Entre 30,0 e 39,0 = obesidade
        Maior que 40,0 = obesidade grave
     */

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f) {
            "NORMAL"
        } else if (result in 25.00f..29.9f) {
            "SOBREPESO"
        } else if (result in 30.0f..39.0f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassicacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}
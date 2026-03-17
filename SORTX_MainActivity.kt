/* Curso: Análise e Desenvolvimento de Sistemas
    Aluno: Saulo Torres de Oliveira Assis
    Professor: André Gustavo
    Projeto: SORT-X - Onde o acaso encontra a intuição
*/

package com.example.sortx

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var segredoX = Random.nextInt(1, 11)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoChute = findViewById<EditText>(R.id.idEntrada)
        val btnDesvendar = findViewById<Button>(R.id.idBotaoChute)
        val status = findViewById<TextView>(R.id.idTextoStatus)

        btnDesvendar.setOnClickListener {
            val textoDigitado = campoChute.text.toString()

            if (textoDigitado == "") {
                Toast.makeText(applicationContext, "Digite um número!", Toast.LENGTH_SHORT).show()
            } else {
                val chute = textoDigitado.toInt()

                if (chute == segredoX) {
                    status.text = "Sucesso! O segredo era $segredoX"
                    segredoX = Random.nextInt(1, 11)
                    Toast.makeText(applicationContext, "Novo X gerado!", Toast.LENGTH_SHORT).show()
                } else if (chute < segredoX) {
                    status.text = "Tente um valor maior que $chute"
                } else {
                    status.text = "Tente um valor menor que $chute"
                }
            }
        }
    }
}
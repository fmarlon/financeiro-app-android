package dev.estudos.android.financeiro.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import dev.estudos.android.financeiro.databinding.ActivityFormContaBinding
import dev.estudos.android.financeiro.model.Banco

class FormContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormContaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormContaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bancos = listOf(
            Banco(1, "Banco do Brasil"),
            Banco(237, "Bradesco"),
            Banco(104, "Caixa Economica"),
            Banco(33, "Santander")
        )
        ArrayAdapter(this, android.R.layout.simple_spinner_item, bancos).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spnBanco.adapter = adapter
        }
    }

}
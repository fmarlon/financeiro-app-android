package dev.estudos.android.financeiro.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.financeiro.databinding.ActivityContasBinding
import dev.estudos.android.financeiro.model.Banco
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.ui.adapters.ContaViewAdapter


class ContasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContasBinding.inflate(layoutInflater)

        setContentView(binding.root)

        title = "MINHAS CONTAS"

        val list = listOf(
            Conta(1, "Minha Conta BB", Banco(id = 1), agencia = "2809-6", numero = "28088-7"),
            Conta(1, "Minha Conta Bradesco", Banco(id = 237), agencia = "0475", numero = "2009-5"),
            Conta(1, "Minha Conta Caixa", Banco(id = 104), agencia = "2546-2", numero = "103002546-0"),
            Conta(1, "Minha Conta Santander", Banco(id = 33), agencia = "103566-5", numero = "1022548-8")
        )

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.listview.layoutManager = layoutManager

        binding.listview.adapter =
            ContaViewAdapter(list)

    }

    fun btnAdicionarClick(view: View) {
        startActivity(Intent(this, FormContaActivity::class.java))
    }

}
package dev.estudos.android.financeiro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.ui.contas.ListaContasActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btContasClick(view: View) {
        startActivity(Intent(this, ListaContasActivity::class.java))
    }

    fun btCategoriasClick(view: View) {

    }

    fun btLancamentosClick(view: View) {

    }

}
package dev.estudos.android.financeiro.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.financeiro.FinanceiroApp
import dev.estudos.android.financeiro.data.AppDatabase
import dev.estudos.android.financeiro.data.ContaDao
import dev.estudos.android.financeiro.databinding.ActivityContasBinding
import dev.estudos.android.financeiro.model.OperationType
import dev.estudos.android.financeiro.ui.adapters.ContaRecycleViewAdapter
import dev.estudos.android.financeiro.utils.MockData

class ContasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContasBinding

    val contaDao : ContaDao by lazy {
        (this.application as FinanceiroApp).database.contaDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContasBinding.inflate(layoutInflater)

        setContentView(binding.root)

        title = "MINHAS CONTAS"

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.listview.layoutManager = layoutManager
    }

    override fun onResume() {
        super.onResume()

        val contas = contaDao.getAll()

        binding.listview.adapter = ContaRecycleViewAdapter(contas)
    }

    fun btnAdicionarClick(view: View) {
        startActivity(
            Intent(this, FormContaActivity::class.java)
                .putExtra("OPERATION_TYPE", OperationType.INSERT)
        )
    }

}
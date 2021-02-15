package dev.estudos.android.financeiro.ui.contas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.financeiro.databinding.ActivityContasBinding
import dev.estudos.android.financeiro.model.OperationType
import dev.estudos.android.financeiro.ui.adapters.ContaRecycleViewAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class ListaContasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContasBinding

    val viewModel : ListaContasViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding.setLifecycleOwner(this)

        title = "MINHAS CONTAS"

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.listview.layoutManager = layoutManager
    }

    override fun onResume() {
        super.onResume()

        val contas = viewModel.getContas()

        binding.listview.adapter = ContaRecycleViewAdapter(contas)
    }

    fun btnAdicionarClick(view: View) {
        startActivity(
            Intent(this, FormContaActivity::class.java)
                .putExtra("OPERATION_TYPE", OperationType.INSERT)
        )
    }

}
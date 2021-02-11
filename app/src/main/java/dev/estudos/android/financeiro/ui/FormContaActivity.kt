package dev.estudos.android.financeiro.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.databinding.ActivityFormContaBinding
import dev.estudos.android.financeiro.model.Banco
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.ui.adapters.CustomSpinnerAdapter

class FormContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormContaBinding

    var conta: Conta? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Cadastro de Conta"

        binding = ActivityFormContaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bancos = listOf(
            Banco(0, ""),
            Banco(1, "Banco do Brasil"),
            Banco(237, "Bradesco"),
            Banco(104, "Caixa Economica"),
            Banco(33, "Santander")
        )

        val bancoAdapter = CustomSpinnerAdapter(this, R.layout.banco_spinner_item, bancos)
        bancoAdapter.setDropDownViewResource(R.layout.banco_spinner_item)
        binding.spnBanco.adapter = bancoAdapter

        conta = intent.getSerializableExtra("CONTA") as Conta?
        popularComponentes()
    }

    private fun popularComponentes() {
        conta?.let {
            binding.txtNome.text.append(it.nome)
            binding.txtAgencia.text.append(it.agencia)
            binding.txtNumero.text.append(it.numero)
            binding.spnBanco.setSelection((binding.spnBanco.adapter as CustomSpinnerAdapter).getPosition(it.banco))
        }
    }

    fun btnSalvarClick(view: View) {
        Toast.makeText(this, "Nao implementado", Toast.LENGTH_SHORT).show()
        // this.finish()
    }

    fun btnFecharClick(view: View) {
        this.finish()
    }

}
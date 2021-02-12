package dev.estudos.android.financeiro.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.databinding.ActivityFormContaBinding
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.ui.CONTA_EXTRA_PARAM
import dev.estudos.android.financeiro.ui.adapters.BancoSpinnerAdapter
import dev.estudos.android.financeiro.ui.setSelectionItem
import dev.estudos.android.financeiro.utils.MockData

class FormContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormContaBinding

    var conta: Conta? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Cadastro de Conta"

        binding = ActivityFormContaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bancoAdapter = BancoSpinnerAdapter(this, R.layout.banco_spinner_item, MockData.BANCOS)
        bancoAdapter.setDropDownViewResource(R.layout.banco_spinner_item)
        binding.spnBanco.adapter = bancoAdapter

        conta = intent.getSerializableExtra(CONTA_EXTRA_PARAM) as Conta?
        popularComponentes()
    }

    private fun popularComponentes() {
        conta?.let {
            binding.txtNome.text.append(it.nome)
            binding.txtAgencia.text.append(it.agencia)
            binding.txtNumero.text.append(it.numero)
            binding.spnBanco.setSelectionItem(it.banco)
        }
    }

    fun btnSalvarClick(view: View) {
        Toast.makeText(this, "Nao implementado", Toast.LENGTH_SHORT).show()
    }

    fun btnFecharClick(view: View) {
        this.finish()
    }

}
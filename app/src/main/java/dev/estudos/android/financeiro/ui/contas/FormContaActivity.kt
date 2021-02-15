package dev.estudos.android.financeiro.ui.contas

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.databinding.ActivityFormContaBinding
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.model.OperationType
import dev.estudos.android.financeiro.ui.adapters.BancoSpinnerAdapter
import dev.estudos.android.financeiro.ui.utils.CONTA_EXTRA_PARAM
import dev.estudos.android.financeiro.ui.utils.OPERATION_TYPE_PARAM
import dev.estudos.android.financeiro.ui.utils.ValidationException
import dev.estudos.android.financeiro.ui.utils.valueProperty
import dev.estudos.android.financeiro.utils.MockData
import org.koin.android.viewmodel.ext.android.viewModel

class FormContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormContaBinding

    val viewModel: FormContaViewModel by viewModel()

    val fieldsMap : Map<String, View> by lazy { mapOf<String, View>(
        "nome" to binding.txtNome,
        "banco" to binding.spnBanco,
        "agencia" to binding.txtAgencia,
        "numero" to binding.txtNumero
    )}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.operationType = intent.getSerializableExtra(OPERATION_TYPE_PARAM) as OperationType

        title = "Cadastro de Conta"

        binding = ActivityFormContaBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        binding.setLifecycleOwner(this)

        binding.spnBanco.valueProperty = "id"

        val bancoAdapter = BancoSpinnerAdapter(this, R.layout.banco_spinner_item, MockData.BANCOS)
        bancoAdapter.setDropDownViewResource(R.layout.banco_spinner_item)
        binding.spnBanco.adapter = bancoAdapter

        viewModel.conta = intent.getSerializableExtra(CONTA_EXTRA_PARAM) as Conta? ?: Conta()

        binding.conta = viewModel.conta
    }

    fun btnSalvarClick(view: View) {
        try {
            viewModel.save()

            Toast.makeText(this, viewModel.savingMessage, Toast.LENGTH_SHORT).show()

            this.finish()
        } catch (e: ValidationException) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            fieldsMap[e.field]?.requestFocus()
        } catch (e: Exception) {
            Toast.makeText(this, "Erro inesperado: $e", Toast.LENGTH_SHORT).show()
        }
    }
    fun btnFecharClick(view: View) {
        this.finish()
    }

}
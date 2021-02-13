package dev.estudos.android.financeiro.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.data.ContaDao
import dev.estudos.android.financeiro.databinding.ActivityFormContaBinding
import dev.estudos.android.financeiro.getDao
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.model.OperationType
import dev.estudos.android.financeiro.ui.*
import dev.estudos.android.financeiro.ui.adapters.BancoSpinnerAdapter
import dev.estudos.android.financeiro.utils.MockData

class FormContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormContaBinding
    lateinit var operationType : OperationType

    val contaDao: ContaDao by lazy {
        application.getDao(ContaDao::class.java)
    }

    var conta: Conta = Conta()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        operationType = intent.getSerializableExtra(OPERATION_TYPE_PARAM) as OperationType

        title = "Cadastro de Conta"

        binding = ActivityFormContaBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.spnBanco.valueProperty = "id"

        val bancoAdapter = BancoSpinnerAdapter(this, R.layout.banco_spinner_item, MockData.BANCOS)
        bancoAdapter.setDropDownViewResource(R.layout.banco_spinner_item)
        binding.spnBanco.adapter = bancoAdapter

        conta = intent.getSerializableExtra(CONTA_EXTRA_PARAM) as Conta? ?: Conta()

        binding.conta = conta
    }

    fun btnSalvarClick(view: View) {
        try {
            // validar dados
            validateField(binding.txtNome, { conta.nome.isNullOrBlank() }, "Campo nome é obrigatório")
            validateField(binding.spnBanco, { conta.idBanco == null || conta.idBanco == 0 }, "Banco é obrigatório")
            validateField(binding.txtAgencia, { conta.agencia.isNullOrBlank() }, "Campo agência é obrigatório")
            validateField(binding.txtNumero, { conta.numero.isNullOrBlank() }, "Campo número da conta é obrigatório")

            var message: String
            if (isInserting()) {
                contaDao.insert(conta)
                message = "Conta incluida com sucesso"
            } else if (isEditing()) {
                contaDao.update(conta)
                message = "Conta alterada com sucesso"
            } else {
                throw IllegalStateException("Tipo de operação não mapeado: $operationType")
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            this.finish()
        } catch (e: UIValidationException) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            e.view.requestFocus()
        } catch (e: Exception) {
            Toast.makeText(this, "Erro inesperado: $e", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnFecharClick(view: View) {
        this.finish()
    }

    fun isInserting() = operationType == OperationType.INSERT

    fun isEditing() = operationType == OperationType.UPDATE

}
package dev.estudos.android.financeiro.ui.contas

import androidx.lifecycle.ViewModel
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.model.OperationType
import dev.estudos.android.financeiro.repository.ContaRepository
import dev.estudos.android.financeiro.ui.utils.validateField

class FormContaViewModel(val contaRepository: ContaRepository): ViewModel() {

    var conta: Conta = Conta()
    lateinit var operationType : OperationType
    var savingMessage = ""

    fun save() {
        validateFields()

        var message: String
        if (isInserting()) {
            contaRepository.add(conta)
            savingMessage = "Conta incluida com sucesso"
        } else if (isEditing()) {
            contaRepository.update(conta)
            savingMessage = "Conta alterada com sucesso"
        } else {
            throw IllegalStateException("Tipo de operação não mapeado: $operationType")
        }
    }

    private fun validateFields() {
        // validar dados
        validateField(
            "nome",
            { conta.nome.isNullOrBlank() },
            "Campo nome é obrigatório"
        )
        validateField(
            "banco",
            { conta.idBanco == null || conta.idBanco == 0 },
            "Banco é obrigatório"
        )
        validateField(
            "agencia",
            { conta.agencia.isNullOrBlank() },
            "Campo agência é obrigatório"
        )
        validateField(
            "numero",
            { conta.numero.isNullOrBlank() },
            "Campo número da conta é obrigatório"
        )
    }

    fun isInserting() = operationType == OperationType.INSERT

    fun isEditing() = operationType == OperationType.UPDATE

}
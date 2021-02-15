package dev.estudos.android.financeiro.ui.contas

import androidx.lifecycle.ViewModel
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.repository.ContaRepository

class ListaContasViewModel(val contaRepository: ContaRepository): ViewModel() {

    fun getContas(): List<Conta> {
        return contaRepository.getAll()
    }

}
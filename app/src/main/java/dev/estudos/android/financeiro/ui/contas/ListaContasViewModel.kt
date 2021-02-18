package dev.estudos.android.financeiro.ui.contas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.repository.ContaRepository
import kotlinx.coroutines.launch

class ListaContasViewModel(val contaRepository: ContaRepository): ViewModel() {

    private val _contasLiveData = MutableLiveData<List<Conta>>()

    val contasLiveData: LiveData<List<Conta>> = _contasLiveData

    fun getContas() {
        viewModelScope.launch {
            val contas = contaRepository.getAll()
            _contasLiveData.value = contas
        }
    }

}
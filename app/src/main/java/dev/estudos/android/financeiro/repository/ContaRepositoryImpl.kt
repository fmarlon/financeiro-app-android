package dev.estudos.android.financeiro.repository

import dev.estudos.android.financeiro.data.ContaDao
import dev.estudos.android.financeiro.model.Conta

class ContaRepositoryImpl(val contaDao: ContaDao): ContaRepository {

    override fun add(conta: Conta) {
        contaDao.insert(conta)
    }

    override fun update(conta: Conta) {
        contaDao.update(conta)
    }

    override fun getAll(): List<Conta> {
        return contaDao.getAll()
    }

}
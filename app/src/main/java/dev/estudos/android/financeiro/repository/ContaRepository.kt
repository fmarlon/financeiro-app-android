package dev.estudos.android.financeiro.repository

import dev.estudos.android.financeiro.model.Conta

interface ContaRepository {

    fun add(conta: Conta)

    fun update(conta: Conta)

    fun getAll(): List<Conta>

}
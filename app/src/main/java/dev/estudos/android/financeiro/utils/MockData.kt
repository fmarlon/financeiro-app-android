package dev.estudos.android.financeiro.utils

import dev.estudos.android.financeiro.model.Banco
import dev.estudos.android.financeiro.model.Conta

object MockData {

    val BANCOS = listOf(
        Banco(0, ""),
        Banco(1, "Banco do Brasil"),
        Banco(237, "Bradesco"),
        Banco(104, "Caixa Economica"),
        Banco(33, "Santander")
    )

    val CONTAS = listOf(
        Conta(1, "Minha Conta BB", Banco(id = 1), agencia = "2809-6", numero = "28088-7"),
        Conta(1, "Minha Conta Bradesco", Banco(id = 237), agencia = "0475", numero = "2009-5"),
        Conta(1, "Minha Conta Caixa", Banco(id = 104), agencia = "2546-2", numero = "103002546-0"),
        Conta(1, "Minha Conta Santander", Banco(id = 33), agencia = "103566-5", numero = "1022548-8")
    )

}
package dev.estudos.android.financeiro.model

import java.io.Serializable
import java.math.BigDecimal

data class Conta (
    val id : Int = 0,
    val nome: String = "",
    val banco: Banco = Banco(),
    val numero: String = "",
    val agencia: String = "",
    val saldo: BigDecimal = BigDecimal.ZERO
): Serializable
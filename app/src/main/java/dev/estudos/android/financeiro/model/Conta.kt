package dev.estudos.android.financeiro.model

import java.io.Serializable
import java.math.BigDecimal

data class Conta (
    val id : Int = 0,
    var nome: String = "",
    var banco: Banco = Banco(),
    var numero: String = "",
    var agencia: String = "",
    var saldo: BigDecimal = BigDecimal.ZERO
): Serializable
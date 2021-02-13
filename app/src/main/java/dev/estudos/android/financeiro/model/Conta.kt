package dev.estudos.android.financeiro.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.math.BigDecimal

@Entity
data class Conta (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
): Serializable {
    var nome: String = ""
    var idBanco: Int? = 0
    var numero: String = ""
    var agencia: String = ""
    var saldo: BigDecimal = BigDecimal.ZERO

    constructor(id: Int = 0, nome: String, idBanco: Int, numero: String, agencia: String): this(id) {
        this.nome = nome
        this.idBanco = idBanco
        this.numero = numero
        this.agencia = agencia
    }

}
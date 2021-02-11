package dev.estudos.android.financeiro.model

import java.io.Serializable

data class Banco (val id : Int = 0): Serializable {
    var nome: String = ""

    constructor(id: Int, name: String): this(id) {
        this.nome = name
    }

}
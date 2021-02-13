package dev.estudos.android.financeiro.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Banco (@PrimaryKey val id : Int = 0): Serializable {
    @ColumnInfo
    var nome: String = ""

    constructor(id: Int, name: String): this(id) {
        this.nome = name
    }

}
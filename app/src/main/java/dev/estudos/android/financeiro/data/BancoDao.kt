package dev.estudos.android.financeiro.data

import androidx.room.Dao
import androidx.room.Query
import dev.estudos.android.financeiro.model.Banco

@Dao
interface BancoDao {

    @Query("SELECT * FROM Banco")
    fun getAll(): List<Banco>

}
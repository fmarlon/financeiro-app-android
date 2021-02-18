package dev.estudos.android.financeiro.data

import androidx.room.*
import dev.estudos.android.financeiro.model.Conta

@Dao
interface ContaDao {

    @Query("SELECT * FROM Conta")
    suspend fun getAll(): List<Conta>

    @Query("SELECT * FROM Conta WHERE id = :id")
    suspend fun getById(id: Int): Conta

    @Insert
    fun insert(conta: Conta)

    @Update
    fun update(conta: Conta)

    @Delete
    fun delete(conta: Conta)

}
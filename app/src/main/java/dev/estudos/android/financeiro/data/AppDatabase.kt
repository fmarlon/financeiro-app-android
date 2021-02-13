package dev.estudos.android.financeiro.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.estudos.android.financeiro.model.Banco
import dev.estudos.android.financeiro.model.Conta

@Database(entities = arrayOf(Conta::class, Banco::class), version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bancoDao(): BancoDao

    abstract fun contaDao(): ContaDao

}
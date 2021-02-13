package dev.estudos.android.financeiro

import android.app.Application
import android.content.Context
import androidx.room.Room
import dev.estudos.android.financeiro.data.AppDatabase
import dev.estudos.android.financeiro.data.BancoDao
import dev.estudos.android.financeiro.data.ContaDao
import kotlin.reflect.KClass

class FinanceiroApp: Application() {

    val database: AppDatabase by lazy {
        FinanceiroApp.getOrCreateDatabase(this)
    }

    companion object {

        private var dbInstance: AppDatabase? = null

        fun getOrCreateDatabase(context: Context): AppDatabase {
            if (dbInstance == null) {
                dbInstance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "financeiro")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return dbInstance!!
        }
    }

}

fun <T> Application.getDao(daoClass: Class<T>): T {
    val database = FinanceiroApp.getOrCreateDatabase(this)
    return when (daoClass) {
        ContaDao::class.java -> database.contaDao() as T
        BancoDao::class.java -> database.bancoDao() as T
        else -> throw IllegalStateException("Dao class not mapped: ${daoClass.name}")
    }
}
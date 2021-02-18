package dev.estudos.android.financeiro

import android.app.Application
import android.content.Context
import androidx.room.Room
import dev.estudos.android.financeiro.config.appModule
import dev.estudos.android.financeiro.data.AppDatabase
import dev.estudos.android.financeiro.data.BancoDao
import dev.estudos.android.financeiro.data.ContaDao
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import kotlin.reflect.KClass

class FinanceiroApp: Application() {

    val database: AppDatabase by lazy {
        FinanceiroApp.getOrCreateDatabase(this)
    }

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@FinanceiroApp)
            modules(appModule)
        }
    }

    companion object {

        private var dbInstance: AppDatabase? = null

        fun getOrCreateDatabase(context: Context): AppDatabase {
            if (dbInstance == null) {
                dbInstance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "financeiro")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return dbInstance!!
        }
    }

}
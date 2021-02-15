package dev.estudos.android.financeiro.config

import dev.estudos.android.financeiro.FinanceiroApp
import dev.estudos.android.financeiro.data.AppDatabase
import dev.estudos.android.financeiro.data.BancoDao
import dev.estudos.android.financeiro.data.ContaDao
import dev.estudos.android.financeiro.repository.ContaRepository
import dev.estudos.android.financeiro.repository.ContaRepositoryImpl
import dev.estudos.android.financeiro.ui.contas.FormContaViewModel
import dev.estudos.android.financeiro.ui.contas.ListaContasViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<AppDatabase> { FinanceiroApp.getOrCreateDatabase(this.androidApplication()) }

    single<ContaDao> { get(AppDatabase::class.java).contaDao() }

    single<BancoDao> { get(AppDatabase::class.java).bancoDao() }

    single<ContaRepository> { ContaRepositoryImpl(get()) }

    viewModel { FormContaViewModel(get()) }
    viewModel { ListaContasViewModel(get()) }
}
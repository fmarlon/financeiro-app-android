package dev.estudos.android.financeiro.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.databinding.FragmentHomeBinding
import dev.estudos.android.financeiro.ui.contas.ListaContasActivity

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewBinding = FragmentHomeBinding.inflate(inflater, container, false)

        viewBinding.btContas.setOnClickListener { navigateToListaContas() }

        return viewBinding.root
    }

    fun navigateToListaContas() {
        findNavController().navigate(R.id.action_homeFragment_to_listaContasFragment)
    }

    fun btCategoriasClick(view: View) {

    }

    fun btLancamentosClick(view: View) {

    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
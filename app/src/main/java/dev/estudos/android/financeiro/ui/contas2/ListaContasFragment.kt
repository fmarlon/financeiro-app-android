package dev.estudos.android.financeiro.ui.contas2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.ui.contas.ListaContasViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A fragment representing a list of Items.
 */
class ListaContasFragment : Fragment() {

    private var columnCount = 1

    val viewModel : ListaContasViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_conta_list, container, false)

        // Set layout
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
            }
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        val recyclerView = view as RecyclerView

        viewModel.getContas()

        viewModel.contasLiveData.observe(this, Observer {
            recyclerView.adapter = ContaRecyclerViewAdapter(it)
        })
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int = 1) =
            ListaContasFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
package dev.estudos.android.financeiro.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.databinding.BancoSpinnerItemBinding
import dev.estudos.android.financeiro.model.Banco
import dev.estudos.android.financeiro.ui.utils.SpinnerValueBindingAdapter
import dev.estudos.android.financeiro.ui.utils.getImageResource
import dev.estudos.android.financeiro.ui.utils.selectedValue

class BancoSpinnerAdapter(context: Context, val resource: Int, val bancos: List<Banco>) : ArrayAdapter<Banco>(context, resource, bancos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(parent.context)

        if (parent.getTag(R.string.spinner_items_tag) == null) {
            parent.setTag(R.string.spinner_items_tag, bancos)
            val selectedValue = (parent as Spinner).selectedValue
            Log.d("BancoSpinnerAdapter.getView", "setting items tag | currentValue: $selectedValue")
            SpinnerValueBindingAdapter.setSelectedValueForSpinner(parent, selectedValue)
        }

        val binding = BancoSpinnerItemBinding.inflate(layoutInflater, parent, false)

        val banco = bancos[position]

        binding.imgBanco.setImageResource(parent.context.getImageResource("img_banco_${banco.id}"))
        binding.txtNome.text = banco.nome

        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = BancoSpinnerItemBinding.inflate(layoutInflater, parent, false)

        val banco = bancos[position]

        binding.imgBanco.setImageResource(parent.context.getImageResource("img_banco_${banco.id}"))
        binding.txtNome.text = banco.nome

        return binding.root
    }

}
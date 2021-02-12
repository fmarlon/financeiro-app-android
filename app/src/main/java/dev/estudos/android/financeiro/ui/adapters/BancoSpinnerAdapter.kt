package dev.estudos.android.financeiro.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import dev.estudos.android.financeiro.databinding.BancoSpinnerItemBinding
import dev.estudos.android.financeiro.model.Banco
import dev.estudos.android.financeiro.ui.getImageResource

class BancoSpinnerAdapter(context: Context, val resource: Int, val bancos: List<Banco>) : ArrayAdapter<Banco>(context, resource, bancos) {

    fun getPosition(item: Banco): Int {
        return bancos.indexOf(item)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = BancoSpinnerItemBinding.inflate(layoutInflater, parent, false)

        val banco = bancos[position]

        binding.imgBanco.setImageResource(parent.context.getImageResource("img_banco_${banco.id}"))
        binding.txtNome.text = banco.nome

        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }

}
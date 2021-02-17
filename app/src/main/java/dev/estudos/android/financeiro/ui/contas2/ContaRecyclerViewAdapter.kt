package dev.estudos.android.financeiro.ui.contas2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.financeiro.R
import dev.estudos.android.financeiro.databinding.FragmentContaItemBinding
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.ui.utils.getImageResource

class ContaRecyclerViewAdapter(
    private val values: List<Conta>
) : RecyclerView.Adapter<ContaRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_conta_item, parent, false)

        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = ViewHolder(
            FragmentContaItemBinding.inflate(layoutInflater, parent, false)
        )

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    class ViewHolder(val binding: FragmentContaItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var item: Conta? = null

        fun bind(item: Conta) {
            this.item = item
            val image = binding.root.context.getImageResource("img_banco_${item.idBanco}")
            binding.imgBanco.setImageResource(image)
            binding.txtNome.text = item.nome
            binding.txtAgencia.text = item.agencia
            binding.txtNumero.text = item.numero
        }

    }
}
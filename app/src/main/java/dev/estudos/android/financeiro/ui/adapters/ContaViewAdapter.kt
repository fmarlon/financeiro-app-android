package dev.estudos.android.financeiro.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.financeiro.databinding.ItemContaBinding
import dev.estudos.android.financeiro.model.Conta

class ContaViewAdapter(val list: List<Conta>) : RecyclerView.Adapter<ContaViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemContaBinding.inflate(layoutInflater, parent, false)
        );
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(val binding: ItemContaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Conta) {
            val image = getImage("img_banco_${item.banco.id}")
            binding.imgBanco.setImageResource(image)
            binding.txtNome.text = item.nome
            binding.txtAgencia.text = item.agencia
            binding.txtNumero.text = item.numero
        }

        fun getImage(imageName: String): Int {
            val resId: Int = binding.root.context.resources.getIdentifier(
                imageName,
                "drawable",
                binding.root.context.packageName
            )
            return resId
        }

    }

}

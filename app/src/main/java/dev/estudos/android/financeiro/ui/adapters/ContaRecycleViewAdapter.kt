package dev.estudos.android.financeiro.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.financeiro.databinding.ItemContaBinding
import dev.estudos.android.financeiro.model.Conta
import dev.estudos.android.financeiro.ui.CONTA_EXTRA_PARAM
import dev.estudos.android.financeiro.ui.activities.FormContaActivity
import dev.estudos.android.financeiro.ui.getImageResource

class ContaRecycleViewAdapter(val list: List<Conta>) : RecyclerView.Adapter<ContaRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = ViewHolder(
            ItemContaBinding.inflate(layoutInflater, parent, false)
        )
        viewHolder.itemView.setOnClickListener {
            val conta = viewHolder.item!!
            val intent = Intent(parent.context, FormContaActivity::class.java)
            intent.putExtra(CONTA_EXTRA_PARAM, conta)
            parent.context.startActivity(intent)
        }
        return viewHolder;
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(val binding: ItemContaBinding) : RecyclerView.ViewHolder(binding.root) {

        var item: Conta? = null

        fun bind(item: Conta) {
            this.item = item
            val image = binding.root.context.getImageResource("img_banco_${item.banco.id}")
            binding.imgBanco.setImageResource(image)
            binding.txtNome.text = item.nome
            binding.txtAgencia.text = item.agencia
            binding.txtNumero.text = item.numero
        }

    }

}
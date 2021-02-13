package dev.estudos.android.financeiro.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.viewbinding.ViewBinding

abstract class SpinnerValueAdapter<T> (context: Context, val viewBinding: ViewBinding, val items: List<T>, getterValue: (item: T) -> Any) : ArrayAdapter<T>(context, viewBinding.root.id, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = items[position]

        bindItemView(viewBinding.root, item as Any)

        return viewBinding.root
    }

    abstract fun bindItemView(itemView: View, item: Any)

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }

}
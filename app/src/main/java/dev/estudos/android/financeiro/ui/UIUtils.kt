package dev.estudos.android.financeiro.ui

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

fun Context.getImageResource(imageName: String): Int {
    val resId: Int = this.resources.getIdentifier(
        imageName,
        "drawable",
        this.packageName
    )
    return resId
}

fun Spinner.setSelectionItem(item: Any) {
    var position = this.findPosition(item)
    this.setSelection(position)
}

@BindingAdapter("selectionItem")
fun setSelectionItemForSpinner(view: Spinner, item: Any) {
    if (view.selectedItem != item) {
        view.setSelectionItem(item)
    }
}

@InverseBindingAdapter(attribute = "selectionItem")
fun getSelectionItemForSpinner(view: Spinner) : Any {
    return view.selectedItem
}

@BindingAdapter("app:selectionItemAttrChanged")
fun setListeners(view: Spinner, attrChange: InverseBindingListener) {
    view.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

        override fun onNothingSelected(p0: AdapterView<*>?) {
            attrChange.onChange()
        }

        override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, itemId: Long) {
            attrChange.onChange()
        }

    }
}

private fun Spinner.findPosition(item: Any): Int {
    var currentItem: Any? = Any()
    var currentPosition = 0
    var position = -1
    while (currentItem != null) {
        currentItem = this.adapter.getItem(currentPosition)
        if (currentItem == item) {
            position = currentPosition
            break;
        }
        currentPosition++
    }
    return position
}
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

fun validateField(view: View, failFunction: (view: View) -> Boolean, failMessage: String) {
    if (failFunction.invoke(view)) {
        throw UIValidationException(view, failMessage)
    }
}

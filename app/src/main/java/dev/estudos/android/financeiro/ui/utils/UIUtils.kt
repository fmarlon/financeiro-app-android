package dev.estudos.android.financeiro.ui.utils

import android.content.Context
import android.view.View
import kotlin.reflect.KProperty

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
        throw UIValidationException(
            view,
            failMessage
        )
    }
}

fun validateField(field: String, failFunction: () -> Boolean, failMessage: String) {
    if (failFunction.invoke()) {
        throw ValidationException(field, failMessage)
    }
}

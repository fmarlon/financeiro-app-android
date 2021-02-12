package dev.estudos.android.financeiro.ui

import android.content.Context
import android.widget.Spinner

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

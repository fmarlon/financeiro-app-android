package dev.estudos.android.financeiro.ui

import android.view.View
import java.lang.RuntimeException

class UIValidationException(val view: View, message: String): RuntimeException(message) {

}
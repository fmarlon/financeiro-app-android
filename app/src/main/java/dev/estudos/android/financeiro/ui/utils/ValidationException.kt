package dev.estudos.android.financeiro.ui.utils

import android.view.View
import java.lang.RuntimeException

class ValidationException(val field: String, message: String): RuntimeException(message) {

}
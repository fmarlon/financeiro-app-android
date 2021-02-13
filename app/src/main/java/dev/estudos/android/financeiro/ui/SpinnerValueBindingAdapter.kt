package dev.estudos.android.financeiro.ui

import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import dev.estudos.android.financeiro.R

var Spinner.valueProperty: String?
    get() = this.getTag(R.string.spinner_value_property_tag) as String?
    set(value) = this.setTag(R.string.spinner_value_property_tag, value)

var Spinner.selectedValue: Any?
    get() = SpinnerValueBindingAdapter.getSelectedValueForSpinner(this)
    set(value) = SpinnerValueBindingAdapter.setSelectedValueForSpinner(this, value)

fun Spinner.getPositionForValue(value: Any?): Int {
    val items : List<Any>? = this.getTag(R.string.spinner_items_tag) as List<Any>?
    if (value == null || items.isNullOrEmpty()) {
        return -1
    }
    val propertyMember = items[0]::class.members.find { it.name == valueProperty }
    if (propertyMember == null) {
        Log.w("Spinner.getPositionForValue", "Property member not found: $valueProperty")
        return -1
    }
    val item = items.find { item -> propertyMember.call(item) == value }
    return items.indexOf(item)
}

fun Spinner.getValueForPosition(position: Int): Any? {
    if (position == -1) {
        return null;
    }
    val item = getItemAtPosition(position)
    val propertyMember = item::class.members.find { it.name == valueProperty }
    if (propertyMember == null) {
        Log.w("Spinner.getValueForPosition", "Property member not found: $valueProperty")
        return -1
    }
    val value = propertyMember.call(item)
    return value
}

@BindingAdapter("valueProperty")
fun setValuePropertyForSpinner(view: Spinner, value: String?) {
    view.valueProperty = value
}

@InverseBindingAdapter(attribute = "valueProperty")
fun getValuePropertyForSpinner(view: Spinner): String? {
    return view.valueProperty
}

class SpinnerValueBindingAdapter {

    companion object {
        @InverseBindingAdapter(attribute = "selectedValue")
        @JvmStatic fun getSelectedValueForSpinner(view: Spinner): Any? {
            return view.getTag(R.string.spinner_value_tag)
        }

        @BindingAdapter("selectedValue")
        @JvmStatic fun setSelectedValueForSpinner(view: Spinner, value: Any?) {
            view.setTag(R.string.spinner_value_tag, value)

            val currentPosition = view.selectedItemPosition
            val valuePosition = view.getPositionForValue(value)

            if (currentPosition != valuePosition) {
                view.setSelection(valuePosition)
            }
        }

        @BindingAdapter("app:selectedValueAttrChanged")
        @JvmStatic fun setSelectedValueListeners(spinner: Spinner, attrChange: InverseBindingListener) {
            spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    attrChange.onChange()
                }

                override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, itemId: Long) {
                    Log.d("Spinner.AdapterView.OnItemSelectedListener.onItemSelected", "position: $position | itemId: $itemId")
                    spinner.selectedValue = spinner.getValueForPosition(position)
                    attrChange.onChange()
                }

            }
        }
    }

}
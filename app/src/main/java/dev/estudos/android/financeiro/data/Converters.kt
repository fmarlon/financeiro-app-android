package dev.estudos.android.financeiro.data

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {

    @TypeConverter
    fun fromBigDecimal(value: Double?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }

    @TypeConverter
    fun bigDecimalToDouble(bigDecimal: BigDecimal?): Double? {
        return bigDecimal?.toDouble()
    }

}
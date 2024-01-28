package br.com.decorafacil.extension

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toPtBr(): String {
    val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatter.format(this)
}

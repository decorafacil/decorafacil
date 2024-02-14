package br.com.decorafacil.utils

import java.text.NumberFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

val DEFAULT_DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
val PT_BR_CURRENCY_FORMAT: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))

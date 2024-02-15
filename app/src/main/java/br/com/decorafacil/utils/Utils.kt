package br.com.decorafacil.utils

import java.math.BigDecimal
import java.text.ParseException
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

fun bigDecimalFromPtBr(ptBrValue: String): BigDecimal {
    return try {
        BigDecimal(PT_BR_CURRENCY_FORMAT.parse(ptBrValue)?.toString())
    } catch (e: ParseException) {
        try {
            BigDecimal(ptBrValue)
        } catch (e: Exception) {
            BigDecimal.ZERO
        }
    }
}

fun convertDateToLocalDate(date: Date): LocalDate {
    val instant = Instant.ofEpochMilli(date.time)
    return instant.atZone(ZoneId.systemDefault()).toLocalDate()
}

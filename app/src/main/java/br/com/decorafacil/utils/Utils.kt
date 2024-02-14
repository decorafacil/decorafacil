package br.com.decorafacil.utils

import java.math.BigDecimal
import java.text.ParseException

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

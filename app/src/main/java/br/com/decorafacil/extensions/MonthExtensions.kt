package br.com.decorafacil.extensions
import java.time.Month

fun Month.toPtBr(): String {
    return when (this) {
        Month.JANUARY -> "JANEIRO"
        Month.FEBRUARY -> "FEVEREIRO"
        Month.MARCH -> "MARÇO"
        Month.APRIL -> "ABRIL"
        Month.MAY -> "MAIO"
        Month.JUNE -> "JUNHO"
        Month.JULY -> "JULHO"
        Month.AUGUST -> "AGOSTO"
        Month.SEPTEMBER -> "SETEMBRO"
        Month.OCTOBER -> "OUTUBRO"
        Month.NOVEMBER -> "NOVEMBRO"
        Month.DECEMBER -> "DEZEMBRO"
    }
}

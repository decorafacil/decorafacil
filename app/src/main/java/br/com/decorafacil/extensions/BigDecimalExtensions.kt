package br.com.decorafacil.extensions

import br.com.decorafacil.utils.PT_BR_CURRENCY_FORMAT
import java.math.BigDecimal

fun BigDecimal.toPtBr(): String {
    return PT_BR_CURRENCY_FORMAT.format(this)
}

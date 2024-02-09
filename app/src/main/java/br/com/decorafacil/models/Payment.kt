package br.com.decorafacil.models

import java.math.BigDecimal

// TODO - os parâmetros devem ser obrigatórios
class Payment(
    val value: BigDecimal,
    val signal: BigDecimal? = null,
    val remainingToPay: BigDecimal? = null,
    val paid: Boolean = false
) {}

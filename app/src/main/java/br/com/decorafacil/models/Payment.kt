package br.com.decorafacil.models

import java.math.BigDecimal

class Payment(
    val value: BigDecimal,
    val signal: BigDecimal = BigDecimal.ZERO,
    val remainingToPay: BigDecimal = value - signal,
    val paid: Boolean = remainingToPay == BigDecimal.ZERO
) {}

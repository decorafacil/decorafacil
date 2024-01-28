package br.com.decorafacil.models

import java.math.BigDecimal

class Payment(
    val value: BigDecimal,
    val paid: Boolean = false
) {}

package br.com.decorafacil.models

import java.math.BigDecimal

class Payment(
    val client: Client,
    val value: BigDecimal,
    val paid: Boolean = false
) {}

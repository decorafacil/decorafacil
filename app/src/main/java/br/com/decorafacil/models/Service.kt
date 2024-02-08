package br.com.decorafacil.models

import java.math.BigDecimal

class Service(
    val description: String, val value: BigDecimal
) {

    override fun toString(): String {
        return "Descrição: $description - Valor: $value"
    }
}

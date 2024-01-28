package br.com.decorafacil.repository

import br.com.decorafacil.models.Payment

interface PaymentRepository {
    fun findPendingPayments(): List<Payment>
}

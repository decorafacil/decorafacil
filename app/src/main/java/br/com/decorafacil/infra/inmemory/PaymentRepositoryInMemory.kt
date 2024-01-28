package br.com.decorafacil.infra.inmemory

import br.com.decorafacil.models.Client
import br.com.decorafacil.models.Payment
import br.com.decorafacil.repository.PaymentRepository
import java.math.BigDecimal

class PaymentRepositoryInMemory : PaymentRepository {

    override fun findPendingPayments(): List<Payment> {
        return listOf(
            Payment(Client("Pedro Henrique Pereira"), BigDecimal("1150")),
            Payment(Client("Thyago Lobato"), BigDecimal("500.50")),
            Payment(Client("Quesia Mendes Costa"), BigDecimal("350")),
            Payment(Client("Paola Lobato"), BigDecimal("600")),
            Payment(Client("Lucas Nunes"), BigDecimal("12050.78")),
            Payment(Client("Pedro Henrique Pereira"), BigDecimal("450")),
            Payment(Client("Thyago Lobato"), BigDecimal("500.50")),
            Payment(Client("Quesia Mendes Costa"), BigDecimal("350")),
            Payment(Client("Paola Lobato"), BigDecimal("600")),
            Payment(Client("Lucas Nunes"), BigDecimal("800")),
            Payment(Client("Pedro Henrique Pereira"), BigDecimal("450")),
            Payment(Client("Thyago Lobato"), BigDecimal("500.50")),
            Payment(Client("Quesia Mendes Costa"), BigDecimal("350")),
            Payment(Client("Paola Lobato"), BigDecimal("600")),
            Payment(Client("Lucas Nunes"), BigDecimal("800"))
        )
    }

}
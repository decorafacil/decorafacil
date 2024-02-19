package br.com.decorafacil.infra.inmemory

import br.com.decorafacil.models.Address
import br.com.decorafacil.models.Client
import br.com.decorafacil.models.Event
import br.com.decorafacil.models.EventTimetable
import br.com.decorafacil.models.Payment
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

class Utils {
    companion object {
        private fun generateRandomClient(): Client {
            val contractor = listOf(
                "Lucas Silva Nunes Menezes",
                "Mariana Oliveira da Cunha",
                "Rafael Santos Silva de Souza",
                "Pedro Henrique Pereira Almeida",
                "Thyago Lobato da Silva",
                "Lucas Nunes Monteiro"
            ).random()
            val birthdayPersonName =
                listOf(
                    "Enzo da Silva Nunes Menezes",
                    "Lara Oliveira da Cunha",
                    "Mateus Santos Silva de Souza",
                    "Mariana da Silva Pereira Almeida",
                    "Lorenzo de Paula Monteiro"
                ).random()
            val age = (18..60).random()
            return Client(contractor, birthdayPersonName, age)
        }

        private fun generateRandomPayment(): Payment {
            val amount = BigDecimal((500..2000).random())
            return Payment(amount)
        }

        private fun generateRandomTimetable(): EventTimetable {
            val dayClosedRange = listOf(2..4, 10..13, 25..28).random()
            val date = LocalDate.of(2024, (1..12).random(), dayClosedRange.random())
            val startTime = LocalTime.of((8..20).random(), 0)
            val endTime = LocalTime.of((21..23).random(), 0)
            return EventTimetable(date, startTime, endTime)
        }

        private fun generateRandomAddress(): Address {
            val street = listOf("Rua da Paz", "Avenida Central", "Travessa das Flores").random()
            val neighborhood = listOf("Bela Vista", "Centro", "Jardim das Rosas").random()
            val city = listOf("Cidade Tranquila", "Vila Feliz", "Nova Esperança").random()
            val state = listOf("Minas Gerais", "São Paulo", "Rio de Janeiro").random()
            val number = (1..100).random().toString()
            val zipCode = "78901234"
            return Address(street, neighborhood, city, state, number, zipCode)
        }

        fun generateRandomEvent(): Event {
            val client = generateRandomClient()
            val payment = generateRandomPayment()
            val timetable = generateRandomTimetable()
            val address = generateRandomAddress()
            val canceled = listOf(true, false).random()
            return Event(client, payment, timetable, address, canceled = canceled)
        }
    }
}
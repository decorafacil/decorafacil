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
                "Lucas Silva",
                "Mariana Oliveira",
                "Rafael Santos",
                "Pedro Henrique",
                "Thyago Lobato",
                "Lucas Nunes"
            ).random()
            val birthdayPersonName =
                listOf(
                    "Enzo da Silva",
                    "Lara Oliveira",
                    "Mateus Santos",
                    "Mariana da Silva",
                    "Lorenzo de Paula"
                ).random()
            val age = (18..60).random()
            return Client(contractor, birthdayPersonName, age)
        }

        private fun generateRandomPayment(): Payment {
            val amount = BigDecimal((500..2000).random())
            return Payment(amount)
        }

        private fun generateRandomTimetable(): EventTimetable {
            val date = LocalDate.of(2024, (1..12).random(), (1..28).random())
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
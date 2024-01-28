package br.com.decorafacil.infra.inmemory

import br.com.decorafacil.models.Address
import br.com.decorafacil.models.Client
import br.com.decorafacil.models.Event
import br.com.decorafacil.models.EventTimetable
import br.com.decorafacil.models.Payment
import br.com.decorafacil.repository.EventRepository
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

class EventRepositoryInMemory : EventRepository {

    override fun findEventsWithPendingPayments(): List<Event> {
        return listOf(
            Event(Client("Lucas Silva"), Payment(BigDecimal("1200")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 3, 22)), Address("Rua da Paz", "Bela Vista", "Cidade Tranquila", "Minas Gerais", "45", "78901234")),
            Event(Client("Ana Souza Oliveira"), Payment(BigDecimal("950")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 4, 17)), Address("Rua Principal", "Vila Feliz", "Cidade Felicidade", "Bahia", "20", "56789012")),
            Event(Client("Maria Oliveira Santos"), Payment(BigDecimal("800")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 2, 9)), Address("Avenida Brasil", "Centro", "Cidade Alegre", "Rio de Janeiro", "123", "12345678")),
            Event(Client("Fernanda Santos"), Payment(BigDecimal("1300")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 5, 5)), Address("Rua da Amizade", "América", "Cidade Amiga", "Santa Catarina", "10", "34567890")),
            Event(Client("Carlos Santos"), Payment(BigDecimal("900")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 8, 7)), Address("Avenida da Esperança", "Esperança", "Cidade Esperançosa", "Rio Grande do Sul", "15", "01234567")),
            Event(Client("Rodrigo Silva Costa"), Payment(BigDecimal("950")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 10, 10)), Address("Avenida da Juventude", "Jovem", "Cidade Jovial", "Pernambuco", "18", "45678901")),
            Event(Client("Camila Souza"), Payment(BigDecimal("1200")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 11, 11)), Address("Rua dos Sonhos", "Sonho Real", "Cidade dos Sonhos", "Goiás", "22", "56789012")),
            Event(Client("Larissa Costa"), Payment(BigDecimal("850")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 9, 12)), Address("Rua do Sol", "Sol Nascente", "Cidade do Sol", "Ceará", "25", "23456789")),
            Event(Client("Rafael Oliveira"), Payment(BigDecimal("1100")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 6, 4)), Address("Avenida Central", "Jardim Botânico", "Cidade das Flores", "Paraná", "56", "67890123")),
            Event(Client("Pedro Henrique Pereira"), Payment(BigDecimal("1150")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 1, 30)), Address("Rua Governador da Silva", "Jd. das Flores", "Itapetininga", "São Paulo", "77", "45669890")),
            Event(Client("Amanda Lima"), Payment(BigDecimal("1000")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 7, 24)), Address("Rua da Liberdade", "Liberdade", "Cidade Livre", "São Paulo", "30", "89012345")),
            Event(Client("José Oliveira Lima"), Payment(BigDecimal("1100")), EventTimetable(LocalTime.of(17, 0), LocalTime.of(23, 0), LocalDate.of(2024, 12, 25)), Address("Avenida da Saudade", "Saudade", "Cidade Saudosa", "Paraíba", "29", "67890123")),
        )
    }

    override fun findNextEvents(): List<Event> {
        return findEventsWithPendingPayments().filter {
            it.timetable.date >= LocalDate.now()
        }.sortedBy { it.timetable.date }
    }

}
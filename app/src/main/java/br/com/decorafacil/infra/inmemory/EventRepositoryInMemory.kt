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

    companion object {
        var events = mutableListOf(
            Event(Client("Lucas Silva", "Enzo da Silva", 6), Payment(BigDecimal("1200")), EventTimetable(LocalDate.of(2024, 3, 22), LocalTime.of(17, 0), LocalTime.of(23, 0)), Address("Rua da Paz", "Bela Vista", "Cidade Tranquila", "Minas Gerais", "45", "78901234")),
            Event(Client("Ana Oliveira", "Pedro Oliveira", 3), Payment(BigDecimal("900")), EventTimetable(LocalDate.of(2024, 4, 15), LocalTime.of(14, 0), LocalTime.of(20, 0)), Address("Avenida Principal", "Centro", "Cidade Serena", "São Paulo", "22", "56789012")),
            Event(Client("Carlos Pereira", "Mariana Pereira", 4), Payment(BigDecimal("1500")), EventTimetable(LocalDate.of(2024, 5, 10), LocalTime.of(18, 30), LocalTime.of(22, 0)), Address("Rua das Flores", "Jardim Feliz", "Cidade Alegre", "Rio de Janeiro", "33", "12345678")),
            Event(Client("Fernanda Santos", "Rafael Santos", 2), Payment(BigDecimal("800")), EventTimetable(LocalDate.of(2024, 6, 5), LocalTime.of(15, 0), LocalTime.of(19, 0)), Address("Rua das Estrelas", "Vila Nova", "Cidade Radiante", "Bahia", "10", "98765432")),
            Event(Client("Gabriel Lima", "Isabela Lima", 5), Payment(BigDecimal("2000")), EventTimetable(LocalDate.of(2024, 7, 20), LocalTime.of(19, 0), LocalTime.of(23, 30)), Address("Avenida dos Sonhos", "Lagoa Azul", "Cidade Encantada", "Ceará", "55", "23456789")),
            Event(Client("Juliana Silva", "Ricardo Silva", 1), Payment(BigDecimal("600")), EventTimetable(LocalDate.of(2024, 8, 12), LocalTime.of(16, 0), LocalTime.of(21, 0)), Address("Travessa das Maravilhas", "Monte Verde", "Cidade Fantástica", "Paraná", "15", "87654321")),
            Event(Client("Marcos Oliveira", "Carla Oliveira", 7), Payment(BigDecimal("1800")), EventTimetable(LocalDate.of(2024, 9, 8), LocalTime.of(20, 0), LocalTime.of(1, 0)), Address("Rua dos Desejos", "Vale Feliz", "Cidade Mágica", "Santa Catarina", "28", "54321098")),
            Event(Client("Patricia Pereira", "Guilherme Pereira", 3), Payment(BigDecimal("1200")), EventTimetable(LocalDate.of(2024, 10, 3), LocalTime.of(17, 30), LocalTime.of(22, 30)), Address("Avenida das Maravilhas", "Serra Azul", "Cidade dos Sonhos", "Goiás", "18", "10293847")),
            Event(Client("Rafaela Santos", "João Santos", 2), Payment(BigDecimal("950")), EventTimetable(LocalDate.of(2024, 11, 25), LocalTime.of(14, 30), LocalTime.of(18, 0)), Address("Rua das Ilusões", "Cidade das Águas", "Cidade Iluminada", "Espírito Santo", "40", "67584930")),
            Event(Client("Thiago Lima", "Larissa Lima", 4), Payment(BigDecimal("1300")), EventTimetable(LocalDate.of(2024, 12, 18), LocalTime.of(18, 0), LocalTime.of(22, 30)), Address("Alameda dos Encantos", "Vila Encantada", "Cidade dos Anjos", "Roraima", "9", "38475629")),
        )
    }

    override fun findEventsWithPendingPayments(): List<Event> {
        return events
    }

    override fun findNextEvents(): List<Event> {
        return findEventsWithPendingPayments().filter {
            it.timetable.date >= LocalDate.now()
        }.sortedBy { it.timetable.date }
    }

    override fun save(event: Event) {
        events.add(event)
    }
}
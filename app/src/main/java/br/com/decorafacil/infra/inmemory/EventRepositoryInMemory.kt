package br.com.decorafacil.infra.inmemory

import br.com.decorafacil.models.Event
import br.com.decorafacil.repository.EventRepository
import java.time.LocalDate

class EventRepositoryInMemory : EventRepository {

    companion object {
        var events = List(10000) { Utils.generateRandomEvent() }.toMutableList()
    }

    override fun findEventsByDate(date: LocalDate): List<Event> {
        return events.filter {
            it.timetable.date.isEqual(date)
        }
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
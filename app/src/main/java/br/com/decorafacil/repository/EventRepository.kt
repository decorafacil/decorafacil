package br.com.decorafacil.repository

import br.com.decorafacil.models.Event
import java.time.LocalDate

interface EventRepository {
    fun findEventsByDate(date: LocalDate): List<Event>
    fun findEventsWithPendingPayments(): List<Event>
    fun findNextEvents(): List<Event>
    fun save(event: Event)
}

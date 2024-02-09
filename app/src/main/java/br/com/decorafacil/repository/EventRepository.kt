package br.com.decorafacil.repository

import br.com.decorafacil.models.Event

interface EventRepository {
    fun findEventsWithPendingPayments(): List<Event>
    fun findNextEvents(): List<Event>
    fun save(event: Event)
}

package br.com.decorafacil.models

class Event(
    val client: Client,
    val payment: Payment,
    val timetable: EventTimetable,
    val address: Address,
    val services: List<Service> = emptyList()
) {}

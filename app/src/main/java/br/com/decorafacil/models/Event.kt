package br.com.decorafacil.models

class Event(
    val client: Client,
    val payment: Payment,
    val timetable: EventTimetable,
    val address: Address,
    val services: List<Service> = emptyList(),
    val canceled: Boolean = false
) {

    override fun toString(): String {
        return "$address\n$timetable\nAniversariante: ${client.birthdayPersonName}"
    }
}

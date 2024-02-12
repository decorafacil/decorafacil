package br.com.decorafacil.models

import br.com.decorafacil.utils.DEFAULT_DATE_FORMAT
import java.time.LocalDate
import java.time.LocalTime

class EventTimetable(
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime
) {

    override fun toString(): String {
        return "${DEFAULT_DATE_FORMAT.format(date)} - $startTime - $endTime"
    }
}

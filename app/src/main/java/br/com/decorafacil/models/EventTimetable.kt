package br.com.decorafacil.models

import java.time.LocalDate
import java.time.LocalTime

class EventTimetable(
    val startTime: LocalTime,
    val endTime: LocalTime,
    val date: LocalDate = LocalDate.now()
) {}

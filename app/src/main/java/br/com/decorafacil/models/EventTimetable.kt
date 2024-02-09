package br.com.decorafacil.models

import java.time.LocalDate
import java.time.LocalTime

class EventTimetable(
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime
) {}

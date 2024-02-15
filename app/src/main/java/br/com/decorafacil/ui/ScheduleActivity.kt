package br.com.decorafacil.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityScheduleBinding
import br.com.decorafacil.infra.inmemory.EventRepositoryInMemory
import br.com.decorafacil.repository.EventRepository
import br.com.decorafacil.ui.activity.HomeActivity
import br.com.decorafacil.ui.recyclerView.ScheduleEventsAdapter
import br.com.decorafacil.utils.convertDateToLocalDate
import com.applandeo.materialcalendarview.CalendarDay
import com.applandeo.materialcalendarview.listeners.OnCalendarDayClickListener
import java.time.LocalDate

class ScheduleActivity : AppCompatActivity() {

    private val eventRepository: EventRepository = EventRepositoryInMemory()
    private var events = eventRepository.findEventsByDate(LocalDate.now())
    private val eventsRecyclerViewAdapter = ScheduleEventsAdapter(
        this,
        events
    )

    private val binding by lazy {
        ActivityScheduleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configCalendarView()
        configButtonBack()
        configNextEventsRecyclerView()
    }

    private fun configCalendarView() {
        val calendarView = binding.calendarView
        calendarView.setOnCalendarDayClickListener(object : OnCalendarDayClickListener {
            override fun onClick(calendarDay: CalendarDay) {
                val selectedDate = convertDateToLocalDate(calendarDay.calendar.time)
                events = eventRepository.findEventsByDate(selectedDate)
                eventsRecyclerViewAdapter.updateEvents(events)
            }
        })
    }

    private fun configNextEventsRecyclerView() {
        val recyclerView = binding.recyclerViewNextEvents
        recyclerView.adapter = eventsRecyclerViewAdapter
    }

    private fun configButtonBack() {
        binding.imageViewArrowLeft.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}
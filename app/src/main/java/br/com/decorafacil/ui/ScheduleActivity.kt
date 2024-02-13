package br.com.decorafacil.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityScheduleBinding
import br.com.decorafacil.infra.inmemory.EventRepositoryInMemory
import br.com.decorafacil.repository.EventRepository
import br.com.decorafacil.ui.activity.HomeActivity
import br.com.decorafacil.ui.recyclerView.ScheduleEventsAdapter
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
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
            events = eventRepository.findEventsByDate(selectedDate)
            eventsRecyclerViewAdapter.updateEvents(events)
        }
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
package br.com.decorafacil.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.R
import br.com.decorafacil.databinding.ActivityScheduleBinding
import br.com.decorafacil.infra.inmemory.EventRepositoryInMemory
import br.com.decorafacil.models.Event
import br.com.decorafacil.repository.EventRepository
import br.com.decorafacil.ui.activity.HomeActivity
import br.com.decorafacil.ui.recyclerView.ScheduleEventsAdapter
import br.com.decorafacil.utils.convertDateToLocalDate
import com.applandeo.materialcalendarview.CalendarDay
import com.applandeo.materialcalendarview.listeners.OnCalendarDayClickListener
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener
import java.time.LocalDate
import java.util.Calendar

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
        configVisibilityNoEventsMessage()
    }

    private fun configCalendarView() {
        val calendarView = binding.calendarView
        val now = LocalDate.now()
        calendarView.setCalendarDays(
            createHighlightedDays(
                eventRepository.findEventsBy(
                    now.month,
                    now.year
                )
            )
        )

        calendarView.setOnCalendarDayClickListener(object : OnCalendarDayClickListener {
            override fun onClick(calendarDay: CalendarDay) {
                val selectedDate = convertDateToLocalDate(calendarDay.calendar.time)
                events = eventRepository.findEventsByDate(selectedDate)
                eventsRecyclerViewAdapter.updateEvents(events)
                configVisibilityNoEventsMessage()
            }
        })

        calendarView.setOnForwardPageChangeListener(createPageChangeListener())
        calendarView.setOnPreviousPageChangeListener(createPageChangeListener())
    }

    fun configVisibilityNoEventsMessage() {
        if (events.isEmpty()) {
            binding.emptyMessage.visibility = View.VISIBLE
            binding.recyclerViewNextEvents.visibility = View.GONE
        } else {
            binding.emptyMessage.visibility = View.GONE
            binding.recyclerViewNextEvents.visibility = View.VISIBLE
        }
    }

    private fun createPageChangeListener(): OnCalendarPageChangeListener {
        return object : OnCalendarPageChangeListener {
            override fun onChange() {
                val firstDayOfPage =
                    convertDateToLocalDate(binding.calendarView.currentPageDate.time)
                val eventsOfMonth =
                    eventRepository.findEventsBy(firstDayOfPage.month, firstDayOfPage.year)
                val highlightedDays = createHighlightedDays(eventsOfMonth)
                binding.calendarView.setCalendarDays(highlightedDays)
            }
        }
    }

    private fun createHighlightedDays(events: List<Event>): List<CalendarDay> {
        val highlightedDays = mutableListOf<CalendarDay>()
        for (event in events) {
            val calendar = Calendar.getInstance().apply {
                set(
                    event.timetable.date.year,
                    event.timetable.date.monthValue - 1,
                    event.timetable.date.dayOfMonth
                )
            }
            val calendarDay = CalendarDay(calendar).apply {
                backgroundResource = R.drawable.ring_purple
            }
            highlightedDays.add(calendarDay)
        }
        return highlightedDays
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
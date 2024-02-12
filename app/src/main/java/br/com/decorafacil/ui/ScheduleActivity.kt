package br.com.decorafacil.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityScheduleBinding
import br.com.decorafacil.infra.inmemory.EventRepositoryInMemory
import br.com.decorafacil.repository.EventRepository
import br.com.decorafacil.ui.activity.HomeActivity
import br.com.decorafacil.ui.recyclerView.ScheduleEventsAdapter

class ScheduleActivity : AppCompatActivity() {

    private val eventRepository: EventRepository = EventRepositoryInMemory()
    private val binding by lazy {
        ActivityScheduleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configButtonBack()
        configNextEventsRecyclerView()
    }

    private fun configNextEventsRecyclerView() {
        val nextEventsRecyclerViewAdapter = ScheduleEventsAdapter(
            this,
            eventRepository.findNextEvents()
        )
        val recyclerView = binding.recyclerViewNextEvents
        recyclerView.adapter = nextEventsRecyclerViewAdapter
    }

    private fun configButtonBack() {
        binding.imageViewArrowLeft.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}
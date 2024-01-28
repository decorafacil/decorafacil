package br.com.decorafacil.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.R
import br.com.decorafacil.databinding.ActivityHomeBinding
import br.com.decorafacil.infra.inmemory.EventRepositoryInMemory
import br.com.decorafacil.repository.EventRepository
import br.com.decorafacil.ui.recyclerView.NextEventsAdapter
import br.com.decorafacil.ui.recyclerView.PendingPaymentsAdapter
import br.com.decorafacil.ui.recyclerView.model.HiddenOrVisibleEvent

class HomeActivity : AppCompatActivity() {

    private val eventRepository: EventRepository = EventRepositoryInMemory()
    private val eventsWithPendingPayments = eventRepository.findEventsWithPendingPayments()
    private var isPendingPaymentsVisible = false
    private val hiddenOrVisibleEvents: List<HiddenOrVisibleEvent> =
        eventsWithPendingPayments.map { event ->
            HiddenOrVisibleEvent(event, isPendingPaymentsVisible)
        }
    private val pendingPaymentsRecyclerViewAdapter = PendingPaymentsAdapter(
        context = this,
        events = hiddenOrVisibleEvents,
    )
    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configPendingPaymentsRecyclerView()
        configNextEventsRecyclerView()
        configEyeToggleVisible()
    }

    private fun configPendingPaymentsRecyclerView() {
        val recyclerView = binding.recyclerViewPendingPayments
        recyclerView.adapter = pendingPaymentsRecyclerViewAdapter
    }

    private fun configNextEventsRecyclerView() {
        val nextEventsRecyclerViewAdapter = NextEventsAdapter(
            this,
            eventRepository.findNextEvents()
        )
        val recyclerView = binding.recyclerViewNextEvents
        recyclerView.adapter = nextEventsRecyclerViewAdapter
    }

    private fun configEyeToggleVisible() {
        val eyeToggle = binding.imageViewEyeHideValues
        eyeToggle.setOnClickListener {
            isPendingPaymentsVisible = !isPendingPaymentsVisible
            for (event in hiddenOrVisibleEvents) {
                event.visible = isPendingPaymentsVisible
            }
            pendingPaymentsRecyclerViewAdapter.notifyItemRangeChanged(
                0,
                eventsWithPendingPayments.size
            )
            eyeToggle.setImageResource(if (isPendingPaymentsVisible) R.drawable.eye_visible_values else R.drawable.eye_hidden_values)
        }
    }

}

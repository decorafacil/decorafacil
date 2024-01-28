package br.com.decorafacil.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityHomeBinding
import br.com.decorafacil.infra.inmemory.EventRepositoryInMemory
import br.com.decorafacil.repository.EventRepository
import br.com.decorafacil.ui.recyclerView.PendingPaymentsAdapter

class HomeActivity : AppCompatActivity() {

    private val eventRepository: EventRepository = EventRepositoryInMemory()

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configPendingPaymentsRecyclerView()
    }

    private fun configPendingPaymentsRecyclerView() {
        val pendingPaymentsRecyclerViewAdapter = PendingPaymentsAdapter(
            context = this,
            events = eventRepository.findEventsWithPendingPayments()
        )
        val recyclerView = binding.recyclerViewPendingPayments
        recyclerView.adapter = pendingPaymentsRecyclerViewAdapter
    }

}

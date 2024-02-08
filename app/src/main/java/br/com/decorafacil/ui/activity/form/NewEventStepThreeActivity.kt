package br.com.decorafacil.ui.activity.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityNewEventStepThreeBinding
import br.com.decorafacil.models.Service
import br.com.decorafacil.ui.recyclerView.EventServicesAdapter
import java.math.BigDecimal

class NewEventStepThreeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewEventStepThreeBinding.inflate(layoutInflater)
    }
    private val eventServiceAdapter = EventServicesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configRecyclerViewServices()
        configFabAddService()
    }

    private fun configFabAddService() {
        val addButton = binding.fabAddService
        val editTextServiceDescription = binding.editTextService
        val editTextServicePrice = binding.editTextPrice
        addButton.setOnClickListener {
            eventServiceAdapter.addItem(
                Service(
                    editTextServiceDescription.text.toString(),
                    BigDecimal(editTextServicePrice.text.toString())
                )
            )
        }
    }

    private fun configRecyclerViewServices() {
        val recyclerView = binding.recyclerViewServices
        recyclerView.adapter = eventServiceAdapter
    }

}
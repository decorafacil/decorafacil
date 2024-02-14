package br.com.decorafacil.ui.activity.form.newevent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import br.com.decorafacil.databinding.ActivityNewEventStepThreeBinding
import br.com.decorafacil.extensions.toPtBr
import br.com.decorafacil.infra.inmemory.EventRepositoryInMemory
import br.com.decorafacil.models.Address
import br.com.decorafacil.models.Client
import br.com.decorafacil.models.Event
import br.com.decorafacil.models.EventTimetable
import br.com.decorafacil.models.Payment
import br.com.decorafacil.models.Service
import br.com.decorafacil.repository.EventRepository
import br.com.decorafacil.ui.activity.HomeActivity
import br.com.decorafacil.ui.activity.form.newevent.data.StepOneData
import br.com.decorafacil.ui.activity.form.newevent.data.StepTwoData
import br.com.decorafacil.ui.recyclerView.EventServicesAdapter
import br.com.decorafacil.utils.bigDecimalFromPtBr
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class NewEventStepThreeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewEventStepThreeBinding.inflate(layoutInflater)
    }
    private val eventServiceAdapter = EventServicesAdapter(this)
    private val eventRepository: EventRepository = EventRepositoryInMemory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configRecyclerViewServices()
        configFabAddService()
        configSaveButton()
        configButtonBack()
        configEditTextSignal()
        configEditTextTotal()
        configEditTextRemaining()
    }

    private fun configFabAddService() {
        val addButton = binding.fabAddService
        val editTextServiceDescription = binding.editTextService
        val editTextServicePrice = binding.editTextPrice
        addButton.setOnClickListener {
            val service = Service(
                editTextServiceDescription.text.toString(),
                BigDecimal(editTextServicePrice.text.toString())
            )
            binding.editTextTotal.setText(
                bigDecimalFromPtBr(binding.editTextTotal.text.toString()).add(service.value)
                    .toPtBr()
            )
            eventServiceAdapter.addItem(service)
        }
    }

    private fun configRecyclerViewServices() {
        val recyclerView = binding.recyclerViewServices
        recyclerView.adapter = eventServiceAdapter
        eventServiceAdapter.registerAdapterDataObserver(
            CustomServicesObserver(
                binding,
                eventServiceAdapter
            )
        )
    }

    private fun configSaveButton() {
        val buttonSave = binding.buttonSave
        buttonSave.setOnClickListener {
            val stepOneData = intent.getParcelableExtra<StepOneData>("stepOneData")
            val stepTwoData = intent.getParcelableExtra<StepTwoData>("stepTwoData")
            val event = Event(
                client = Client(
                    stepOneData!!.clientName,
                    stepTwoData!!.birthdayPersonName,
                    stepTwoData.birthdayPersonAgeToComplete.toInt()
                ),
                payment = Payment(
                    BigDecimal(binding.editTextTotal.text.toString()),
                    BigDecimal(binding.editTextSignal.text.toString()),
                    BigDecimal(binding.editTextRemaining.text.toString())
                ),
                timetable = EventTimetable(
                    LocalDate.parse(
                        stepTwoData.eventDate,
                        DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale("pt", "BR"))
                    ),
                    LocalTime.parse(stepTwoData.eventTimeStart),
                    LocalTime.parse(stepTwoData.eventTimeEnd)
                ),
                address = Address(
                    stepTwoData.eventStreet,
                    stepTwoData.eventDistrict,
                    stepTwoData.eventCity,
                    stepTwoData.eventState,
                    stepTwoData.eventPlaceNumber,
                    stepTwoData.eventZipCode,
                    stepTwoData.eventComplement
                ),
                services = eventServiceAdapter.getServices()
            )
            eventRepository.save(event)
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun configButtonBack() {
        binding.imageViewArrowLeft.setOnClickListener {
            startActivity(Intent(this, NewEventStepTwoActivity::class.java))
        }
    }

    private fun configEditTextSignal() {
        val editTextSignal = binding.editTextSignal
        editTextSignal.setText(BigDecimal.ZERO.toPtBr())
        editTextSignal.setOnKeyListener { _, _, _ ->
            val signal = bigDecimalFromPtBr(editTextSignal.text.toString())
            val total = bigDecimalFromPtBr(binding.editTextTotal.text.toString())
            binding.editTextRemaining.setText(total.subtract(signal).toPtBr())
            false
        }
    }

    private fun configEditTextTotal() {
        val editTextTotal = binding.editTextTotal
        editTextTotal.setText(BigDecimal.ZERO.toPtBr())
        editTextTotal.addTextChangedListener {
            val signal = bigDecimalFromPtBr(binding.editTextSignal.text.toString())
            val total = bigDecimalFromPtBr(binding.editTextTotal.text.toString())
            binding.editTextRemaining.setText(total.subtract(signal).toPtBr())
        }
    }

    private fun configEditTextRemaining() {
        binding.editTextRemaining.setText(BigDecimal.ZERO.toPtBr())
        binding.editTextRemaining.isEnabled = false
    }
}

class CustomServicesObserver(
    private val binding: ActivityNewEventStepThreeBinding,
    private val adapter: EventServicesAdapter
) : RecyclerView.AdapterDataObserver() {
    override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
        super.onItemRangeRemoved(positionStart, itemCount)
        val services = adapter.getServices()
        val totalServices =
            if (services.isNotEmpty()) {
                services.map { it.value }.reduceOrNull { acc, value -> acc.add(value) }
            } else {
                BigDecimal.ZERO
            }
        binding.editTextTotal.setText(BigDecimal.ZERO.add(totalServices).toPtBr())
    }
}

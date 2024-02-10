package br.com.decorafacil.ui.activity.form.newevent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityNewEventStepTwoBinding
import br.com.decorafacil.ui.activity.form.newevent.data.StepOneData
import br.com.decorafacil.ui.activity.form.newevent.data.StepTwoData
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NewEventStepTwoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewEventStepTwoBinding.inflate(layoutInflater)
    }
    private val timeFormat = TimeFormat.CLOCK_24H
    private val datePickerEventDate =
        MaterialDatePicker.Builder.datePicker().setTitleText("Selecione a data").build()
    private val timePickerEventStartTime =
        MaterialTimePicker.Builder().setTimeFormat(timeFormat).setHour(12).setMinute(0)
            .setTitleText("Horário de início").build()
    private val timePickerEventEndTime =
        MaterialTimePicker.Builder().setTimeFormat(timeFormat).setHour(12).setMinute(0)
            .setTitleText("Horário de término").build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configEditTextEventDate()
        configEditTextEventStartTime()
        configEditTextEventEndTime()
        configNextButton()
    }

    private fun configEditTextEventDate() {
        val editTextDate = binding.editTextEventDate
        editTextDate.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editTextDate.clearFocus()
                datePickerEventDate.show(supportFragmentManager, datePickerEventDate.toString())
            }
        }
        datePickerEventDate.addOnPositiveButtonClickListener { selection ->
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
            val formattedDate = dateFormat.format(Date(selection))
            editTextDate.setText(formattedDate)
        }
    }

    private fun configEditTextEventStartTime() {
        val editTextStartTime = binding.editTextEventStartTime
        editTextStartTime.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editTextStartTime.clearFocus()
                timePickerEventStartTime.show(
                    supportFragmentManager,
                    timePickerEventEndTime.toString()
                )
            }
        }
        timePickerEventStartTime.addOnPositiveButtonClickListener {
            val minuteFormatted = "%02d".format(timePickerEventStartTime.minute)
            val hourFormatted = "%02d".format(timePickerEventStartTime.hour)
            editTextStartTime.setText("$hourFormatted:${minuteFormatted}")
        }
    }

    private fun configEditTextEventEndTime() {
        val editTextEndTime = binding.editTextEventEndTime
        editTextEndTime.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editTextEndTime.clearFocus()
                timePickerEventEndTime.show(
                    supportFragmentManager,
                    timePickerEventEndTime.toString()
                )
            }
        }
        timePickerEventEndTime.addOnPositiveButtonClickListener {
            val minuteFormatted = "%02d".format(timePickerEventEndTime.minute)
            val hourFormatted = "%02d".format(timePickerEventEndTime.hour)
            editTextEndTime.setText("$hourFormatted:$minuteFormatted")
        }

    }

    private fun configNextButton() {
        binding.buttonNext.setOnClickListener {
            startActivity(Intent(this, NewEventStepThreeActivity::class.java).apply {
                putExtra(
                    "stepOneData",
                    intent.getParcelableExtra<StepOneData>("stepOneData")
                )
                putExtra(
                    "stepTwoData",
                    StepTwoData(
                        binding.editTextEventZipCode.text.toString(),
                        binding.editTextEventStreet.text.toString(),
                        binding.editTextEventPlaceNumber.text.toString(),
                        binding.editTextEventDistrict.text.toString(),
                        binding.editTextEventCity.text.toString(),
                        binding.dropDownEventState.text.toString(),
                        binding.editTextEventComplement.text.toString(),
                        binding.editTextEventDate.text.toString(),
                        binding.editTextEventStartTime.text.toString(),
                        binding.editTextEventEndTime.text.toString(),
                        binding.editTextBirthdayPersonName.text.toString(),
                        binding.editTextBirthdayPersonAge.text.toString(),
                    )
                )
            })
        }
    }

}

package br.com.decorafacil.ui.activity.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityNewEventStepTwoBinding
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

}

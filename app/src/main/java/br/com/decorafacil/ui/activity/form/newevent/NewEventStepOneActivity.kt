package br.com.decorafacil.ui.activity.form.newevent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityNewEventStepOneBinding
import br.com.decorafacil.ui.activity.form.newevent.data.StepOneData

class NewEventStepOneActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityNewEventStepOneBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        binding.buttonNext.setOnClickListener {
            startActivity(Intent(this, NewEventStepTwoActivity::class.java).apply {
                putExtra(
                    "stepOneData",
                    StepOneData(
                        binding.editTextClientName.text.toString(),
                        binding.editTextClientCpf.text.toString(),
                        binding.editTextClientPhoneNumber.text.toString(),
                        binding.editTextClientEmail.text.toString()
                    )
                )
            })
        }
    }

}
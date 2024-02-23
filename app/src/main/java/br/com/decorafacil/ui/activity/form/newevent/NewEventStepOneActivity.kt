package br.com.decorafacil.ui.activity.form.newevent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityNewEventStepOneBinding
import br.com.decorafacil.ui.activity.HomeActivity
import br.com.decorafacil.ui.activity.form.newevent.data.StepOneData
import br.com.decorafacil.ui.activity.masks.CPF_MASK
import br.com.decorafacil.ui.activity.masks.PHONE_NUMBER_MASK
import com.santalu.maskara.MaskChangedListener

class NewEventStepOneActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityNewEventStepOneBinding.inflate(layoutInflater)
    }
    private val cpfMaskListener = MaskChangedListener(CPF_MASK)
    private val phoneNumberMaskListener = MaskChangedListener(PHONE_NUMBER_MASK)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configButtonNext()
        configButtonBack()
        configEditTextCpf()
        configEditTextPhoneNumber()
    }

    private fun configButtonNext() {
        binding.buttonNext.setOnClickListener {
            startActivity(Intent(this, NewEventStepTwoActivity::class.java).apply {
                putExtra(
                    "stepOneData",
                    StepOneData(
                        binding.editTextClientName.text.toString(),
                        cpfMaskListener.unMasked,
                        phoneNumberMaskListener.unMasked,
                        binding.editTextClientEmail.text.toString()
                    )
                )
            })
        }
    }

    private fun configButtonBack() {
        binding.imageViewArrowLeft.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun configEditTextCpf() {
        binding.editTextClientCpf.addTextChangedListener(cpfMaskListener)
    }

    private fun configEditTextPhoneNumber() {
        binding.editTextClientPhoneNumber.addTextChangedListener(phoneNumberMaskListener)
    }

}
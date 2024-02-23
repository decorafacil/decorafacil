package br.com.decorafacil.ui.activity.form.newevent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityNewEventStepOneBinding
import br.com.decorafacil.ui.activity.HomeActivity
import br.com.decorafacil.ui.activity.form.newevent.data.StepOneData
import br.com.decorafacil.ui.activity.masks.CPF_MASK
import br.com.decorafacil.ui.activity.masks.PHONE_NUMBER_MASK
import com.google.android.material.textfield.TextInputEditText
import com.santalu.maskara.MaskChangedListener

class NewEventStepOneActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityNewEventStepOneBinding.inflate(layoutInflater)
    }
    private lateinit var editTextClientName: TextInputEditText
    private lateinit var editTextClientCpf: TextInputEditText
    private lateinit var editTextClientPhoneNumber: TextInputEditText
    private lateinit var editTextClientEmail: TextInputEditText
    private val cpfMaskListener = MaskChangedListener(CPF_MASK)
    private val phoneNumberMaskListener = MaskChangedListener(PHONE_NUMBER_MASK)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeFields()
        configComponents()
    }

    private fun initializeFields() {
        editTextClientName = binding.editTextClientName
        editTextClientCpf = binding.editTextClientCpf
        editTextClientPhoneNumber = binding.editTextClientPhoneNumber
        editTextClientEmail = binding.editTextClientEmail
    }

    private fun configComponents() {
        configButtonNext()
        configButtonBack()
        configEditTextCpf()
        configEditTextPhoneNumber()
    }

    private fun configButtonNext() {
        binding.buttonNext.setOnClickListener {
            if (!formDataIsValid()) {
                return@setOnClickListener
            }
            startActivity(Intent(this, NewEventStepTwoActivity::class.java).apply {
                putExtra(
                    "stepOneData",
                    StepOneData(
                        editTextClientName.text.toString(),
                        cpfMaskListener.unMasked,
                        phoneNumberMaskListener.unMasked,
                        editTextClientEmail.text.toString()
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
        editTextClientCpf.addTextChangedListener(cpfMaskListener)
    }

    private fun configEditTextPhoneNumber() {
        editTextClientPhoneNumber.addTextChangedListener(phoneNumberMaskListener)
    }

    private fun formDataIsValid(): Boolean {
        var isValid = true
        if (editTextClientName.text.toString().trim().isEmpty()) {
            editTextClientName.error = "O campo '${editTextClientName.hint}' é obrigatório"
            isValid = false
        }
        return isValid
    }

}
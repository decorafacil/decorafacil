package br.com.decorafacil.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.decorafacil.databinding.ActivityFinancialBinding
import br.com.decorafacil.extensions.toPtBr
import java.time.LocalDate
import java.time.Month

class FinancialActivity : AppCompatActivity() {

    private var currentMonth: Month = Month.entries[LocalDate.now().monthValue - 1]

    private val binding by lazy {
        ActivityFinancialBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configComponents()
        updateMonthText()
    }

    private fun configComponents() {
        configLeftArrowButton()
        configRightArrowButton()
    }

    private fun configLeftArrowButton() {
        val buttonLeftArrow = binding.imageViewLeftArrow
        buttonLeftArrow.setOnClickListener {
            currentMonth = currentMonth.minus(1)
            updateMonthText()
        }
    }

    private fun configRightArrowButton() {
        val buttonRightArrow = binding.imageViewRightArrow
        buttonRightArrow.setOnClickListener {
            currentMonth = currentMonth.plus(1)
            updateMonthText()
        }
    }

    private fun updateMonthText() {
        binding.editTextMonth.setText(currentMonth.toPtBr())
    }
}
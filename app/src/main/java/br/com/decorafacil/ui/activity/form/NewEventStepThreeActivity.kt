package br.com.decorafacil.ui.activity.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityNewEventStepThreeBinding

class NewEventStepThreeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewEventStepThreeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}
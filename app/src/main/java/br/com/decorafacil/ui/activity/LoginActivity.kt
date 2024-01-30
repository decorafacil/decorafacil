package br.com.decorafacil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.decorafacil.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        goToUserRegisterActivity()
        goToHomeActivity()

    }

    private fun goToUserRegisterActivity() {
        val btnCriarConta = findViewById<TextView>(R.id.textViewCreateAccount)

        btnCriarConta.setOnClickListener {
            val intent = Intent(this, UserRegisterActivity::class.java)
            startActivity(intent)

        }
    }

    private fun goToHomeActivity() {
        val btnEntrar = findViewById<Button>(R.id.buttonLogin)

        btnEntrar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }


}
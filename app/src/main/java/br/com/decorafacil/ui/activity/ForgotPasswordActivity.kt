package br.com.decorafacil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.decorafacil.R

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        goToUserRegisterActivity()
    }

    private fun goToUserRegisterActivity() {
        val btnCriarConta = findViewById<TextView>(R.id.textViewCreateAccountForgotPassword)

        btnCriarConta.setOnClickListener {
            val intent = Intent(this, UserRegisterActivity::class.java)
            startActivity(intent)

        }
    }
}
package br.com.decorafacil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.com.decorafacil.R

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        goToUserRegisterActivity()
        backToLoginActivity()
        goToPasswordResetActivity()
    }

    private fun goToUserRegisterActivity() {
        val btnCriarConta = findViewById<TextView>(R.id.textViewCreateAccountForgotPassword)

        btnCriarConta.setOnClickListener {
            val intent = Intent(this, UserRegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun backToLoginActivity() {
        val btnBackArrow = findViewById<ImageView>(R.id.imageViewForgotPasswordLeftArrow)

        btnBackArrow.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToPasswordResetActivity() {
        val btnSendCode = findViewById<Button>(R.id.btnSendCodeForgotPassword)

        btnSendCode.setOnClickListener {
            val intent = Intent(this, PasswordResetActivity::class.java)
            startActivity(intent)
        }
    }
}
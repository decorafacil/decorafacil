package br.com.decorafacil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.com.decorafacil.R

class PasswordResetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        backToForgotPasswordActivity()
    }

    private fun backToForgotPasswordActivity() {
        val btnBackArrow = findViewById<ImageView>(R.id.imageViewLeftArrowPasswordReset)

        btnBackArrow.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}
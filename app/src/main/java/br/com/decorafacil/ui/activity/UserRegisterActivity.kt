package br.com.decorafacil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import br.com.decorafacil.R

class UserRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        backToLoginActivity()
        backToHomeActivityAfterSaveUserInformations()
    }

    private fun backToLoginActivity() {
        val btnBackArrow = findViewById<ImageView>(R.id.leftarrow)

        btnBackArrow.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun backToHomeActivityAfterSaveUserInformations() {
        val btnSaveUserInformation = findViewById<ImageButton>(R.id.imageButtonSaveUser)

        btnSaveUserInformation.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            Toast.makeText(applicationContext, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }
}
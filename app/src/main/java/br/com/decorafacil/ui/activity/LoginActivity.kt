package br.com.decorafacil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.decorafacil.R
import br.com.decorafacil.infra.inmemory.UserRepositoryInMemory
import br.com.decorafacil.repository.UserRepository
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private val userRepository: UserRepository = UserRepositoryInMemory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        goToHomeActivity()
        goToUserRegisterActivity()
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

            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
            val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

            if (isRegisteredUser(email, password)) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                val mensagem = "Os dados de login estão incorretos. Por favor, tente novamente."
                exibirSnackbar(mensagem)
            }
        }
    }

    private fun isRegisteredUser(email: String, password: String): Boolean {
        return userRepository.findUserByEmailAndPassword(email, password) != null
    }

    private fun exibirSnackbar(mensagem: String) {
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content),
            mensagem,
            Snackbar.LENGTH_SHORT
        )
        snackbar.show()
    }
}
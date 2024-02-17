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
        configComponents()
    }

    private fun configComponents() {
        configCreateAccountButton()
        configEnterButton()
        configForgotPasswordButton()
    }

    private fun configCreateAccountButton() {
        val buttonCreateAccount = findViewById<TextView>(R.id.textViewCreateAccount)

        buttonCreateAccount.setOnClickListener {
            val intent = Intent(this, UserRegisterActivity::class.java)
            startActivity(intent)

        }
    }

    private fun configEnterButton() {

        val buttonEnter = findViewById<Button>(R.id.buttonLogin)

        buttonEnter.setOnClickListener {

            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
            val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

            if (isRegisteredUser(email, password)) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                val message = "Os dados de login estão incorretos. Por favor, tente novamente."
                showSnackBar(message)
            }
        }
    }

    private fun configForgotPasswordButton() {

        val buttonForgotPassword = findViewById<TextView>(R.id.textViewForgotPassword)

        buttonForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isRegisteredUser(email: String, password: String): Boolean {
        return userRepository.findUserByEmailAndPassword(email, password) != null
    }

    private fun showSnackBar(message: String) {
        val snackBar = Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        )
        snackBar.show()
    }
}
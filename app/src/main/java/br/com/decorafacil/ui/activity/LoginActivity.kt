package br.com.decorafacil.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.R
import br.com.decorafacil.databinding.ActivityLoginBinding
import br.com.decorafacil.infra.inmemory.UserRepositoryInMemory
import br.com.decorafacil.repository.UserRepository
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private val userRepository: UserRepository = UserRepositoryInMemory()

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configCreateAccountButton()
        configEnterButton()
        configForgotPasswordButton()
    }

    private fun configCreateAccountButton() {
        val buttonCreateAccount =  binding.textViewCreateAccount
        buttonCreateAccount.setOnClickListener {
            val intent = Intent(this, UserRegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configEnterButton() {
        val buttonEnter = binding.buttonLogin
        buttonEnter.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
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
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        )
        snackBar.show()
    }
}
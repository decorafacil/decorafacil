package br.com.decorafacil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import br.com.decorafacil.R
import br.com.decorafacil.infra.inmemory.UserRepositoryInMemory
import br.com.decorafacil.models.Address
import br.com.decorafacil.models.User
import br.com.decorafacil.repository.UserRepository
import java.lang.Exception

class UserRegisterActivity : AppCompatActivity() {

    private val userRepository: UserRepository = UserRepositoryInMemory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        backToLoginActivity()
        saveUserData()
    }

    private fun backToLoginActivity() {
        val btnBackArrow = findViewById<ImageView>(R.id.imageViewUserLeftArrow)

        btnBackArrow.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveUserData() {
        val btnSaveUserInformation = findViewById<ImageButton>(R.id.imageButtonSaveUser)

        btnSaveUserInformation.setOnClickListener {

            val fantasyName = findViewById<EditText>(R.id.editTextFantasyName).text.toString()
            val name = findViewById<EditText>(R.id.editTextUserName).text.toString()
            val cpf = findViewById<EditText>(R.id.editTextUserCpf).text.toString()
            val phoneNumber = findViewById<EditText>(R.id.editTextUserPhoneNumber).text.toString()
            val email = findViewById<EditText>(R.id.editTextUserEmail).text.toString()

            val street = findViewById<EditText>(R.id.editTextUserStreetAddress).text.toString()
            val addressNumber =
                findViewById<EditText>(R.id.editTextUserAddressNumber).text.toString()
            val district = findViewById<EditText>(R.id.editTextUserDistrict).text.toString()
            val complement = findViewById<EditText>(R.id.editTextUserComplement).text.toString()
            val city = findViewById<EditText>(R.id.editTextUserCity).text.toString()

            val address = Address(street, district, city, "", addressNumber, "", complement)

            var password = findViewById<EditText>(R.id.editTextUserPassword).text.toString()
            var confirmPassword = findViewById<EditText>(R.id.editTextUserConfirmPassword).text.toString()

            if (password == confirmPassword) {
                val user = User(
                    fantasyName,
                    name,
                    cpf,
                    phoneNumber,
                    email,
                    address,
                    password,
                )

                try {
                    userRepository.save(user)
                } catch (e: Exception) {
                    throw Exception("Erro ao tentar salvar um novo usuário. Mensagem de erro: " + e.message)
                }

                backToHomeActivity()
            } else {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun backToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

        Toast.makeText(applicationContext, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show()
    }
}
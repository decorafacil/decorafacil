package br.com.decorafacil.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.decorafacil.databinding.ActivityUserRegisterBinding
import br.com.decorafacil.infra.inmemory.UserRepositoryInMemory
import br.com.decorafacil.models.Address
import br.com.decorafacil.models.User
import br.com.decorafacil.repository.UserRepository

class UserRegisterActivity : AppCompatActivity() {

    private val userRepository: UserRepository = UserRepositoryInMemory()

    private val binding by lazy {
        ActivityUserRegisterBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configComponents()
    }

    private fun configComponents() {
        configBackArrowButton()
        saveUserData()
        fillUserData()
    }

    private fun configBackArrowButton() {
        val buttonBackArrow = binding.imageViewUserLeftArrow
        buttonBackArrow.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configSaveUserInformationButton() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        Toast.makeText(applicationContext, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show()
    }

    private fun saveUserData() {
        val buttonSaveUserInformation = binding.imageButtonSaveUser
        buttonSaveUserInformation.setOnClickListener {
            val fantasyName = binding.editTextFantasyName.text.toString()
            val name = binding.editTextUserName.text.toString()
            val cpf = binding.editTextUserCpf.text.toString()
            val phoneNumber = binding.editTextUserPhoneNumber.text.toString()
            val email = binding.editTextUserEmail.text.toString()
            val zipCode = binding.editTextUserZipCode.text.toString()
            val street = binding.editTextUserStreetAddress.text.toString()
            val addressNumber = binding.editTextUserAddressNumber.text.toString()
            val district = binding.editTextUserDistrict.text.toString()
            val complement = binding.editTextUserComplement.text.toString()
            val city = binding.editTextUserCity.text.toString()
            val state = binding.dropDownUserState.text.toString()
            val address = Address(street, district, city, state, addressNumber, zipCode, complement)
            val password = binding.editTextUserPassword.text.toString()
            val confirmPassword = binding.editTextUserConfirmPassword.text.toString()
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
                    if (isFromHomeActivity()) userRepository.update(user) else userRepository.save(user)
                } catch (e: Exception) {
                    throw Exception("Erro ao tentar salvar um novo usuário. Mensagem de erro: " + e.message)
                }
                configSaveUserInformationButton()
            } else {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isFromHomeActivity(): Boolean {
        val source = intent.getStringExtra("source")
        return source == "home"
    }

    private fun fillUserData() {
        if (isFromHomeActivity()) {
            val user = userRepository.findLoggedUser()
            binding.editTextFantasyName.setText(user.companyName)
            binding.editTextUserName.setText(user.name)
            binding.editTextUserCpf.setText(user.cpf)
            binding.editTextUserPhoneNumber.setText(user.phoneNumber)
            binding.editTextUserEmail.setText(user.email)
            binding.editTextUserZipCode.setText(user.address.zipCode)
            binding.editTextUserStreetAddress.setText(user.address.street)
            binding.editTextUserAddressNumber.setText(user.address.number)
            binding.editTextUserDistrict.setText(user.address.district)
            binding.editTextUserComplement.setText(user.address.complement)
            binding.editTextUserCity.setText(user.address.city)
            binding.dropDownUserState.setText(user.address.state, false)
            binding.editTextUserPassword.setText(user.password)
            binding.editTextUserConfirmPassword.setText(user.password)
        }
    }
}
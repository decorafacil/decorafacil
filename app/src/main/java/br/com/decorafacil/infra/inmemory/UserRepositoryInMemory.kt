package br.com.decorafacil.infra.inmemory

import br.com.decorafacil.models.Address
import br.com.decorafacil.models.User
import br.com.decorafacil.repository.UserRepository

class UserRepositoryInMemory : UserRepository {

    companion object {
        var users =
            mutableListOf(
                User(
                    "Usuário de Teste",
                    "Nome",
                    "123",
                    "123",
                    "teste@teste.com",
                    Address("RUA", "Bairro", "Cidade", "estado", "123", "123", "complemento"),
                    "123"
                )
            )
    }

    override fun findLoggedUser(): User {
        return users.last();
    }

    override fun findUserByEmailAndPassword(email: String, password: String): User? {
        return users.find { it.email == email && it.password == password }
    }

    override fun save(user: User) {
        users.add(user)
    }
}

package br.com.decorafacil.infra.inmemory

import br.com.decorafacil.models.User
import br.com.decorafacil.repository.UserRepository

class UserRepositoryInMemory : UserRepository {

    override fun findLoggedUser(): User {
        return User("Juju Family Fest")
    }

}

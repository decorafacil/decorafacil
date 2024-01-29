package br.com.decorafacil.repository

import br.com.decorafacil.models.User

interface UserRepository {
    fun findLoggedUser(): User
}

package br.com.decorafacil.repository

import br.com.decorafacil.models.User

interface UserRepository {
    fun findLoggedUser(): User
    fun save(user: User)
    fun update(user: User)
    fun findUserByEmailAndPassword(email: String, password: String): User?
    fun findUserByCPF(cpf: String): User
    fun deleteUserByCPF(cpf: String)
}

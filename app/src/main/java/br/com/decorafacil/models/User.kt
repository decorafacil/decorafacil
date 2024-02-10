package br.com.decorafacil.models

class User(
    val companyName: String,
    val name: String,
    val cpf: String,
    val phoneNumber: String,
    val email: String,
    val address: Address,
    val password: String
) {
}
package br.com.decorafacil.models

// TODO - os parâmetros devem ser obrigatórios
class Client(
    val contractor: String,
    val birthdayPersoname: String = "",
    val birthdayPersonAgeToComplete: Int = 0
) {}

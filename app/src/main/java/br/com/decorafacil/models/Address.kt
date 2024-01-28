package br.com.decorafacil.models

class Address(
    val street: String,
    val district: String,
    val city: String,
    val state: String,
    val number: String,
    val zipCode: String,
    val complement: String = ""
) {

    override fun toString(): String {
        return "$street, $number $complement, $district, $city - $state, CEP: $zipCode"
    }

}

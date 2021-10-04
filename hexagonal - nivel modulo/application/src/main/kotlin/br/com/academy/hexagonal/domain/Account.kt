package br.com.academy.hexagonal.aplication.domain

data class Account(
    val id: Long? = null,
    val name: String,
    val agencyNumber: Int,
    val accountNumber: Int
) {
}
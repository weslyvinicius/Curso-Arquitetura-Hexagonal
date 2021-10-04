package br.com.academy.hexagonal.domain

data class AccountSqs(
    val name: String,
    val agencyNumber: Int,
    val accountNumber: Int
)
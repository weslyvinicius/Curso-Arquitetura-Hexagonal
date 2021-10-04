package br.com.academy.hexagonal.domain

import java.util.*

data class Account(
    val id: UUID? = null,
    val name: String,
    val agencyNumber: Int,
    val accountNumber: Int
) {
}
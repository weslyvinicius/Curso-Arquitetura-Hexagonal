package br.com.academy.hexagonal.response

import java.util.*

data class AccountResponse(
    val id: UUID,
    val name: String,
    val agencyNumber: Int,
    val accountNumber: Int)

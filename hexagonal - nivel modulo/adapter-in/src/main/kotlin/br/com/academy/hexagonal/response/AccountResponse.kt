package br.com.academy.hexagonal.adapter.`in`.web.response

data class AccountResponse(
    val id: Long,
    val name: String,
    val agencyNumber: Int,
    val accountNumber: Int)

package br.com.academy.hexagonal.convert

import br.com.academy.hexagonal.domain.Account
import br.com.academy.hexagonal.domain.AccountSqs

fun AccountSqs.toDomain() = Account(
    name = name,
    agencyNumber = agencyNumber,
    accountNumber = accountNumber
)
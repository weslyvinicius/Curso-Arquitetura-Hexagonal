package br.com.academy.hexagonal.convert

import br.com.academy.hexagonal.request.AccountResquest
import br.com.academy.hexagonal.response.AccountResponse
import br.com.academy.hexagonal.domain.Account

fun AccountResquest.toDomain() =
    Account(name = name,
            agencyNumber = agencyNumber,
            accountNumber = accountNumber)

fun Account.toAccountResponse() =
    AccountResponse(id = id!!,
                    name= name,
                    agencyNumber = agencyNumber,
                    accountNumber = accountNumber)
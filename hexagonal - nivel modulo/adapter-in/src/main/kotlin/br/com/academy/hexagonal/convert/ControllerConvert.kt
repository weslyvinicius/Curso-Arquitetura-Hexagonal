package br.com.academy.hexagonal.adapter.`in`.web.convert

import br.com.academy.hexagonal.adapter.`in`.web.request.AccountResquest
import br.com.academy.hexagonal.adapter.`in`.web.response.AccountResponse
import br.com.academy.hexagonal.aplication.domain.Account

fun AccountResquest.toDomain() =
    Account(name = name,
            agencyNumber = agencyNumber,
            accountNumber = accountNumber)

fun Account.toAccountResponse() =
    AccountResponse(id = id!!,
                    name= name,
                    agencyNumber = agencyNumber,
                    accountNumber = accountNumber)
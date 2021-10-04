package br.com.academy.hexagonal.convert

import br.com.academy.hexagonal.domain.Account
import br.com.academy.hexagonal.entity.AccountDynamo

fun AccountDynamo.toDomain() =
    Account(id = id,
        name = name,
        agencyNumber = agencyNumber,
        accountNumber = accountNumber)

fun Account.toAccountDynamo() =
    AccountDynamo(id = id,
        name = name,
        agencyNumber = agencyNumber,
        accountNumber = accountNumber)
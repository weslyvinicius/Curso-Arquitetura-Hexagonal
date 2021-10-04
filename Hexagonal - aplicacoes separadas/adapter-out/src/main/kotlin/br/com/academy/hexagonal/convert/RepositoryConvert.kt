package br.com.academy.hexagonal.convert

import br.com.academy.hexagonal.domain.Account
import br.com.academy.hexagonal.entity.AccountEntity

fun AccountEntity.toDomain() =
    Account(id = id,
            name = name,
            agencyNumber = agencyNumber,
            accountNumber = accountNumber)

fun Account.toAccountEntity() =
    AccountEntity(id = id,
                  name = name,
                  agencyNumber = agencyNumber,
                  accountNumber = accountNumber)
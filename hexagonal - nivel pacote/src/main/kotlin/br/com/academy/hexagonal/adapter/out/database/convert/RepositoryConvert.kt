package br.com.academy.hexagonal.adapter.out.database.convert

import br.com.academy.hexagonal.adapter.out.database.entity.AccountEntity
import br.com.academy.hexagonal.aplication.domain.Account

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
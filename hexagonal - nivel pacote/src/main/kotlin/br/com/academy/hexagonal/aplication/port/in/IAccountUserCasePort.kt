package br.com.academy.hexagonal.aplication.port.`in`

import br.com.academy.hexagonal.aplication.domain.Account

interface IAccountUserCasePort {

    fun createAccount(account: Account)

    fun accountFindAll(): List<Account>
}
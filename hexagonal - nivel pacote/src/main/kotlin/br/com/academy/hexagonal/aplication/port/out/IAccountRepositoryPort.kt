package br.com.academy.hexagonal.aplication.port.out

import br.com.academy.hexagonal.aplication.domain.Account

interface IAccountRepositoryPort {

    fun createAccount(account: Account)

    fun accountFindAll(): List<Account>
}
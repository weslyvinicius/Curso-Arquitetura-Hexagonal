package br.com.academy.hexagonal.port.out

import br.com.academy.hexagonal.domain.Account
import java.util.*

interface IAccountRepositoryPort {

    fun createAccount(account: Account) : Account

    fun accountFindAll(): List<Account>

    fun findById(id: UUID): Account
}
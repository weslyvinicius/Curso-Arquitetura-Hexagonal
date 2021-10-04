package br.com.academy.hexagonal.port.`in`

import br.com.academy.hexagonal.domain.Account
import java.util.*

interface IAccountUserCasePort {

    fun createAccount(account: Account): Account

    fun accountFindAll(): List<Account>

    fun findById(id: UUID): Account
}
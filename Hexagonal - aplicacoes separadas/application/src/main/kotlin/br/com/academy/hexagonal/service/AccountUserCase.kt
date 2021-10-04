package br.com.academy.hexagonal.service

import br.com.academy.hexagonal.domain.Account
import br.com.academy.hexagonal.port.`in`.IAccountUserCasePort
import br.com.academy.hexagonal.port.out.IAccountRepositoryPort
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountUserCase(private val accountRespositoryPort: IAccountRepositoryPort): IAccountUserCasePort {

    override fun createAccount(account: Account) =
        accountRespositoryPort.createAccount(account)


    override fun accountFindAll(): List<Account> =
        accountRespositoryPort.accountFindAll()

    override fun findById(id: UUID): Account =
        accountRespositoryPort.findById(id)


}
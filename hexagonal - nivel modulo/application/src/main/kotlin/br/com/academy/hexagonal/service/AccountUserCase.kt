package br.com.academy.hexagonal.aplication.service

import br.com.academy.hexagonal.aplication.domain.Account
import br.com.academy.hexagonal.aplication.port.`in`.IAccountUserCasePort
import br.com.academy.hexagonal.aplication.port.out.IAccountRepositoryPort
import org.springframework.stereotype.Service

@Service
class AccountUserCase(private val accountRespositoryPort: IAccountRepositoryPort): IAccountUserCasePort {

    override fun createAccount(account: Account) {
        accountRespositoryPort.createAccount(account)
    }

    override fun accountFindAll(): List<Account> =
        accountRespositoryPort.accountFindAll()

}
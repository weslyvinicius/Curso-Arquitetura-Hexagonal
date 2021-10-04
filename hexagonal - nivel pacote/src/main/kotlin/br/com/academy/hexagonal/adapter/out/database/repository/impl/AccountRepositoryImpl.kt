package br.com.academy.hexagonal.adapter.out.database.repository.impl

import br.com.academy.hexagonal.adapter.out.database.convert.toAccountEntity
import br.com.academy.hexagonal.adapter.out.database.convert.toDomain
import br.com.academy.hexagonal.adapter.out.database.repository.IAccountRespository
import br.com.academy.hexagonal.aplication.domain.Account
import br.com.academy.hexagonal.aplication.port.out.IAccountRepositoryPort
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImpl(private val accountRespository: IAccountRespository): IAccountRepositoryPort {

    override fun createAccount(account: Account) {
        accountRespository.save(account.toAccountEntity())
    }


    override fun accountFindAll(): List<Account> =
        accountRespository.findAll().map { accountEntity -> accountEntity.toDomain() }

}
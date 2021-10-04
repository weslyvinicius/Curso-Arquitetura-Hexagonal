package br.com.academy.hexagonal.repository.impl

import br.com.academy.hexagonal.convert.toAccountEntity
import br.com.academy.hexagonal.convert.toDomain
import br.com.academy.hexagonal.domain.Account
import br.com.academy.hexagonal.port.out.IAccountRepositoryPort
import br.com.academy.hexagonal.repository.IAccountRespository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AccountRepositoryImpl(private val accountRespository: IAccountRespository): IAccountRepositoryPort {

    override fun createAccount(account: Account) =
        accountRespository.save(account.toAccountEntity()).toDomain()


    override fun accountFindAll(): List<Account> =
        accountRespository.findAll().map { accountEntity -> accountEntity.toDomain() }

    override fun findById(id: UUID) = accountRespository.findById(id).get().toDomain()
}
package br.com.academy.hexagonal.repository

import br.com.academy.hexagonal.convert.toAccountDynamo
import br.com.academy.hexagonal.convert.toDomain
import br.com.academy.hexagonal.domain.Account
import br.com.academy.hexagonal.entity.AccountDynamo
import br.com.academy.hexagonal.port.out.IAccountRepositoryPort
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import org.springframework.stereotype.Component
import java.util.*




@Component
class AccountRepository(private val dynamoDBMapper: DynamoDBMapper): IAccountRepositoryPort {

    override fun createAccount(account: Account): Account {
        val toAccountDynamo = account.toAccountDynamo()
        dynamoDBMapper.save(toAccountDynamo);
        return toAccountDynamo.toDomain()
    }

    override fun accountFindAll(): List<Account> = emptyList()

    override fun findById(id: UUID): Account =
        dynamoDBMapper.load(AccountDynamo::class.java, id).toDomain()

}

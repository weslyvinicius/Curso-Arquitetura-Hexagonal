package br.com.academy.hexagonal.repository

import br.com.academy.hexagonal.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IAccountRespository : JpaRepository<AccountEntity, UUID> {
}
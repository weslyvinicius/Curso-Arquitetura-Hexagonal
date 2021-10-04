package br.com.academy.hexagonal.adapter.out.database.repository

import br.com.academy.hexagonal.adapter.out.database.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IAccountRespository : JpaRepository<AccountEntity, Long> {
}
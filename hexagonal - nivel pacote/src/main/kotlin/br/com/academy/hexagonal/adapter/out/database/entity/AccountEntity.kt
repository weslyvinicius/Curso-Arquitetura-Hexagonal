package br.com.academy.hexagonal.adapter.out.database.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class AccountEntity(
    @Id @GeneratedValue
    var id: Long?,
    val name: String,
    val agencyNumber: Int,
    val accountNumber: Int
)

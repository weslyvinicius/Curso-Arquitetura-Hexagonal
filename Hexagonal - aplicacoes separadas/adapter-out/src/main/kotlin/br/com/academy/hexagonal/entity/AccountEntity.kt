package br.com.academy.hexagonal.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class AccountEntity(
    @Id @GeneratedValue
    var id: UUID ?= UUID.randomUUID(),
    val name: String,
    val agencyNumber: Int,
    val accountNumber: Int
)

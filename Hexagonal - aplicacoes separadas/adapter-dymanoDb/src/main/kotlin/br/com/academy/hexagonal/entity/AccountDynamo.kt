package br.com.academy.hexagonal.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import java.util.*

@DynamoDBTable(tableName = "accounts")
data class AccountDynamo(

    @DynamoDBHashKey(attributeName = "accountId")
    @DynamoDBAutoGeneratedKey
    var id: UUID?=UUID.randomUUID(),

    @DynamoDBAttribute(attributeName = "accountName")
    var name: String = "",

    @DynamoDBAttribute(attributeName = "accountAgencyNumber")
    var agencyNumber: Int = 0,

    @DynamoDBAttribute(attributeName = "accountNumber")
    var accountNumber: Int = 0
)
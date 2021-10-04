package br.com.academy.hexagonal.config

import br.com.academy.hexagonal.entity.AccountDynamo
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class DynamoDBConfig {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)


    @Value("\${cloud.aws.service.url}")
    private val amazonDynamoDBEndpoint: String? = null

    @Value("\${cloud.aws.credencials.access-key}")
    private val amazonAWSAccessKey: String? = null

    @Value("\${cloud.aws.credentials.secrect-key}")
    private val amazonAWSSecretKey: String? = null

    @Bean
    fun dynamoDBMapper(): DynamoDBMapper {
        val client = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey)
                )
            )
            .withEndpointConfiguration(
                EndpointConfiguration(
                    amazonDynamoDBEndpoint,
                    Regions.US_EAST_1.toString()
                )
            )
            .build()
        //createTableForEntity(client, AccountDynamo::class)
        return DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT)
    }

    private fun createTableForEntity(amazonDynamoDB: AmazonDynamoDB, entity: KClass<AccountDynamo>) {

        val tableRequest = DynamoDBMapper(amazonDynamoDB)
            .generateCreateTableRequest(entity.java)
            .withProvisionedThroughput(ProvisionedThroughput(1L, 1L))

        try {
            DynamoDB(amazonDynamoDB).createTable(tableRequest).waitForActive()
            log.info("Table created! [entity={}]", entity)
        } catch (e: ResourceInUseException) {
            log.info("Table already exists - skip creation! [entity={}]", entity)
        }
    }
}
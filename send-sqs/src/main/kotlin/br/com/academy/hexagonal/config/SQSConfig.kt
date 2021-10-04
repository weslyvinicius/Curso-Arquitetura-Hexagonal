package br.com.academy.hexagonal.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.messaging.converter.MappingJackson2MessageConverter





@Configuration
class SQSConfig(@Value("\${cloud.aws.service.url}") private val endPoint :String,
                @Value("\${cloud.aws.credencials.access-key}") private val awsAccessKey :String,
                @Value("\${cloud.aws.credentials.secrect-key}") private val awsSecretKey :String ) {

     @Bean
     @Primary
     fun amazonSQS(): AmazonSQSAsync {
         return AmazonSQSAsyncClientBuilder.standard()
             .withEndpointConfiguration(endpointConfig())
             .withCredentials(AWSStaticCredentialsProvider(BasicAWSCredentials(awsAccessKey,awsSecretKey)))
             .build()
     }

    private fun endpointConfig() = EndpointConfiguration(
        endPoint,
        Regions.US_EAST_1.toString()
    )

    @Bean
    fun queueMessagingTemplate(amazonSQSAsync: AmazonSQSAsync): QueueMessagingTemplate {
        return QueueMessagingTemplate(amazonSQSAsync)
    }

    @Bean
    fun mappingJackson2MessageConverter(objectMapper: ObjectMapper): MappingJackson2MessageConverter {
        val jacksonMessageConverter = MappingJackson2MessageConverter()
        jacksonMessageConverter.objectMapper = objectMapper
        jacksonMessageConverter.serializedPayloadClass = String::class.java
        jacksonMessageConverter.isStrictContentTypeMatch = true
        return jacksonMessageConverter
    }


}
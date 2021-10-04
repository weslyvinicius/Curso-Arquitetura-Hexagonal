package br.com.academy.hexagonal.controller

import br.com.academy.hexagonal.domain.Account
import br.com.academy.hexagonal.util.JacksonUtils
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.model.SendMessageRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("send/message")
class SendMessageSqs (@Value("\${cloud.aws.sqs.worker.endpoint}") private val queueEndPoint: String,
                      @Value("\${cloud.aws.sqs.queue.name}") private val queue : String,
                      private val amazonSQS: AmazonSQSAsync,
                      private val queueMessagingTemplate: QueueMessagingTemplate
) {

    @PostMapping
    fun sendMessageSQS(@RequestBody account: Account){
        queueMessagingTemplate.convertAndSend(queueEndPoint, account)
    }

    @PostMapping("/text/{text}")
    fun sendMessageSQS(@PathVariable("text") text: String){
        amazonSQS.sendMessage( SendMessageRequest()
            .withQueueUrl(queueEndPoint)
            .withMessageBody(JacksonUtils().fromObject(text)) )
    }

    @PostMapping("/template/{text}")
    fun sendMessageSQSTemplate(@PathVariable("text") text: String){
        queueMessagingTemplate.convertAndSend(queueEndPoint, text)
    }



    private fun builMessageRequest(account: Account): SendMessageRequest {
        return SendMessageRequest()
            .withQueueUrl(queueEndPoint)
            .withMessageBody(JacksonUtils().fromObject(account))
    }
}
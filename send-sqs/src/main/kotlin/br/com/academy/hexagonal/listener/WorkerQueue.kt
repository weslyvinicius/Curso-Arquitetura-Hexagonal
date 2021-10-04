package br.com.academy.hexagonal.listener

import br.com.academy.hexagonal.domain.Account
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener

//@Component
class WorkerQueue() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @SqsListener(value = ["\${cloud.aws.sqs.worker.endpoint}"], deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    fun getMessageFromSqs( account: Account) {
        log.info("Received message= $account")
    }
}
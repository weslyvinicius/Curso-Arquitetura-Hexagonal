package br.com.academy.hexagonal.listener

import br.com.academy.hexagonal.convert.toDomain
import br.com.academy.hexagonal.domain.AccountSqs
import br.com.academy.hexagonal.port.`in`.IAccountUserCasePort
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class WorkerQueue(private val accountUserCasePort: IAccountUserCasePort) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @SqsListener(value = ["\${cloud.aws.sqs.worker.endpoint}"], deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    fun getMessageFromSqs( accountSqs: AccountSqs) {
        log.info("Received message= $accountSqs")

        accountUserCasePort.createAccount(accountSqs.toDomain())

    }
}
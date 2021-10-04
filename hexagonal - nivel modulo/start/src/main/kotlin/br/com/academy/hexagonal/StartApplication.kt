package br.com.academy.hexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["br.com.academy.hexagonal"])
class StartApplication

fun main(args: Array<String>) {
    runApplication<StartApplication>(*args)
}

package br.com.academy.hexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApplicationStartApplication

fun main(args: Array<String>) {
    runApplication<ApplicationStartApplication>(*args)
}

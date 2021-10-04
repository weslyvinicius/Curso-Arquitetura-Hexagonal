package br.com.academy.hexagonal.util

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {

    @Bean
    fun objectMapper() = JacksonUtils().getObjectMapper()
}
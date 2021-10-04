package br.com.academy.hexagonal.util

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

class JacksonUtils() {

    private var objectMapper =  ObjectMapper()
                                .registerModule(SimpleModule())
                                .registerModule(JavaTimeModule())
                                .registerModule(KotlinModule())
                                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                                .configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true)
                                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                                .setSerializationInclusion(JsonInclude.Include.NON_NULL)


    fun getObjectMapper() = objectMapper

    fun fromObject(obj : Any): String {
        return try {
            objectMapper.writeValueAsString(obj)
        }catch (e: JsonProcessingException){
            throw IllegalArgumentException("Objeto nao serializavel para json $e")
        }
    }



}
package com.moontomi.server.core.common

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
@Suppress("UNCHECKED_CAST")
class StringListConverter(
    private val mapper: ObjectMapper
): AttributeConverter<List<String>, String> {
    override fun convertToDatabaseColumn(attribute: List<String>?): String {
        try {
            return mapper.writeValueAsString(attribute)
        } catch (ex: JsonProcessingException) {
            throw IllegalArgumentException("failed to convert $attribute.")
        }
    }

    override fun convertToEntityAttribute(dbData: String?): List<String> {
        try {
            return mapper.readValue(dbData, List::class.java) as List<String>
        } catch (ex: IOException) {
            throw IllegalArgumentException("failed to convert $dbData")
        }
    }
}

@Converter
@Suppress("UNCHECKED_CAST")
class IntListConverter(
    private val mapper: ObjectMapper
): AttributeConverter<List<Int>, String> {
    override fun convertToDatabaseColumn(attribute: List<Int>?): String {
        try {
            return mapper.writeValueAsString(attribute)
        } catch (ex: JsonProcessingException) {
            throw IllegalArgumentException("failed to convert $attribute.")
        }
    }

    override fun convertToEntityAttribute(dbData: String?): List<Int> {
        try {
            return mapper.readValue(dbData, List::class.java) as List<Int>
        } catch (ex: IOException) {
            throw IllegalArgumentException("failed to convert $dbData")
        }
    }
}
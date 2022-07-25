package com.moontomi.server.core.genre

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException
import javax.persistence.*

@Entity
@Table(name = "genre")
class Genre (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    var id: Int?,

    @Column(name = "category")
    var category: GenreCategory,

    @Column(name = "name")
    var name: String
)

enum class GenreCategory {
    POP, ROCK, JAZZ, ELECTRONIC, HIPHOP, RNB, WORLD, EXPERIMENTAL
}

@Converter
@Suppress("UNCHECKED_CAST")
class GenreListConverter(
    private val mapper: ObjectMapper
): AttributeConverter<List<Genre>, String> {
    override fun convertToDatabaseColumn(attribute: List<Genre>?): String {
        try {
            return mapper.writeValueAsString(attribute)
        } catch (ex: JsonProcessingException) {
            throw IllegalArgumentException("failed to convert $attribute.")
        }
    }

    override fun convertToEntityAttribute(dbData: String?): List<Genre> {
        try {
            return mapper.readValue(dbData, List::class.java) as List<Genre>
        } catch (ex: IOException) {
            throw IllegalArgumentException("failed to convert $dbData")
        }
    }
}
package com.moontomi.server.core.album

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.moontomi.server.core.artist.Artist
import com.moontomi.server.core.genre.Genre
import com.moontomi.server.core.image.Image
import java.io.IOException
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "album")
class Album (
    @Id
    @Column(name = "album_id")
    val id: Int,

    @JoinColumn(name = "artist_id")
    @OneToOne(fetch = FetchType.EAGER)
    val artist: Artist,

    @JoinColumn(name = "image_id")
    @OneToOne(fetch = FetchType.EAGER)
    val image: Image,

    @JoinColumn(name = "genre_id")
    @OneToMany(fetch = FetchType.EAGER)
    val genre: Genre,

    @Convert(converter = TracksConverter::class)
    @Column(columnDefinition = "json")
    val tracks: Tracks,

    @Column
    val release: LocalDateTime
)

data class Tracks(
    val list: List<String>
)

@Converter
class TracksConverter(
    private val mapper: ObjectMapper
): AttributeConverter<Tracks, String> {
    override fun convertToDatabaseColumn(attribute: Tracks?): String {
        try {
            return mapper.writeValueAsString(attribute)
        } catch (ex: JsonProcessingException) {
            throw IllegalArgumentException("failed to convert $attribute.")
        }
    }

    override fun convertToEntityAttribute(dbData: String?): Tracks {
        try {
            return mapper.readValue(dbData, Tracks::class.java)
        } catch (ex: IOException) {
            throw IllegalArgumentException("failed to convert $dbData")
        }
    }
}
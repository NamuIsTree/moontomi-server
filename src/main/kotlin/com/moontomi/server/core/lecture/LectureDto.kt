package com.moontomi.server.core.lecture

import com.moontomi.server.core.album.AlbumDto
import com.moontomi.server.core.genre.GenreDto
import com.moontomi.server.core.season.SeasonDto
import java.time.LocalDateTime

data class LectureDto (
    val id: Int,
    val album: AlbumDto,
    val season: SeasonDto,
    val ymd: LocalDateTime
) {
    companion object {
        fun from(lecture: Lecture, genres: List<GenreDto>, season: SeasonDto): LectureDto = LectureDto(
            id = lecture.id!!,
            album = AlbumDto.from(
                album = lecture.album,
                genres = genres
            ),
            season = season,
            ymd = lecture.ymd
        )
    }

    fun to(): Lecture = Lecture(
        id = id,
        album = album.to(),
        season = season.name,
        ymd = ymd
    )
}

data class LectureCreationRequest(
    val albumId: Int,
    val season: String,
    val ymd: LocalDateTime
)
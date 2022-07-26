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
        fun from(lecture: Lecture, genres: List<GenreDto>): LectureDto = LectureDto(
            id = lecture.id!!,
            album = AlbumDto.from(
                album = lecture.album,
                genres = genres
            ),
            season = SeasonDto.from(lecture.season),
            ymd = lecture.ymd
        )
    }

    fun to(): Lecture = Lecture(
        id = id,
        album = album.to(),
        season = season.to(),
        ymd = ymd
    )
}

data class LectureCreationRequest(
    val albumId: Int,
    val season: String,
    val ymd: LocalDateTime
)
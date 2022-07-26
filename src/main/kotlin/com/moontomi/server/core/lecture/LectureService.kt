package com.moontomi.server.core.lecture

import com.moontomi.server.core.album.AlbumService
import com.moontomi.server.core.genre.GenreDto
import com.moontomi.server.core.genre.GenreService
import com.moontomi.server.core.season.SeasonService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LectureService (
    private val lectureRepository: LectureRepository,
    private val albumService: AlbumService,
    private val genreService: GenreService,
    private val seasonService: SeasonService
){
    fun findAll(): List<LectureDto> {
        return lectureRepository.findAll().map {
            val genres = it.album.genres.map { genre ->
                genreService.findById(genre)
            }
            LectureDto.from(it, genres)
        }
    }

    fun findById(id: Int): LectureDto {
        val lecture = lectureRepository.findByIdOrNull(id) ?: throw Exception("lectureId=$id does not exist.")
        val genres = lecture.album.genres.map {
            genreService.findById(it)
        }

        return LectureDto.from(
            lecture = lecture,
            genres = genres
        )
    }

    fun insert(request: LectureCreationRequest): LectureDto {
        val album = albumService.findById(request.albumId)
        val genres = album.genres.map { it.to() }

        val lecture = lectureRepository.save(
            Lecture(
                id = null,
                album = albumService.findById(request.albumId).to(),
                season = seasonService.findById(request.season).to(),
                ymd = request.ymd
            )
        )

        return LectureDto.from(
            lecture = lecture,
            genres = genres.map { GenreDto.from(it) }
        )
    }

    fun update(request: LectureDto) {
        // TODO
    }
}
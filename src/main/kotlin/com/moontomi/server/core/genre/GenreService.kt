package com.moontomi.server.core.genre

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GenreService (
    private val genreRepository: GenreRepository
) {
    fun findById(id: Int): GenreDto {
        return GenreDto.from(
            genreRepository.findByIdOrNull(id) ?: throw Exception("genreId=$id does not exist.")
        )
    }

    fun findByCategory(category: GenreCategory): List<GenreDto> {
        return genreRepository.findByCategory(category).map {
            GenreDto.from(it)
        }
    }

    fun insert(request: GenreCreationRequest): GenreDto {
        return GenreDto.from(
            genreRepository.save(request.to())
        )
    }

    fun update(genre: GenreDto): GenreDto {
        return GenreDto.from(
            genreRepository.save(genre.to())
        )
    }
}
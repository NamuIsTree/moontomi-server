package com.moontomi.server.api.meta

import com.moontomi.server.core.genre.GenreCreationRequest
import com.moontomi.server.core.genre.GenreDto
import com.moontomi.server.core.genre.GenreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GenreController (
    private val genreService: GenreService
) : AbstractMetaController() {
    @GetMapping("/genres.v1")
    fun getGenres(): List<GenreDto> {
        return genreService.findAll()
    }

    @PostMapping("/genre.v1")
    fun postGenre(@RequestBody request: GenreCreationRequest): GenreDto {
        return genreService.insert(request)
    }
}
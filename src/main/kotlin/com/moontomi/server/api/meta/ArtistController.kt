package com.moontomi.server.api.meta

import com.moontomi.server.core.artist.ArtistCreationRequest
import com.moontomi.server.core.artist.ArtistDto
import com.moontomi.server.core.artist.ArtistService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ArtistController(
    private val artistService: ArtistService
) : AbstractMetaController() {

    @GetMapping("/artists.v1")
    fun getArtists(): List<ArtistDto> {
        return artistService.findAll()
    }

    @GetMapping("/artist/{artistId}.v1")
    fun getArtist(@PathVariable artistId: Int): ArtistDto {
        return artistService.findById(artistId)
    }

    @PostMapping("/artist.v1")
    fun postArtist(@RequestBody request: ArtistCreationRequest): ArtistDto {
        return artistService.insert(request)
    }

    @PutMapping("/artist.v1")
    fun putArtist(@RequestBody artist: ArtistDto): ArtistDto {
        return artistService.update(artist)
    }
}
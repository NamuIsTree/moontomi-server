package com.moontomi.server.core.artist

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ArtistService (
    private val artistRepository: ArtistRepository
){
    fun findAll(): List<ArtistDto> {
        return artistRepository.findAll().map {
            ArtistDto.from(it)
        }
    }

    fun findById(id: Int): ArtistDto {
        return ArtistDto.from(
            artistRepository.findByIdOrNull(id) ?: throw Exception("artistId=$id does not exist.")
        )
    }

    fun existById(id: Int): Boolean {
        return artistRepository.existsById(id)
    }

    fun insert(artist: ArtistCreationRequest): ArtistDto {
        return ArtistDto.from(
            artistRepository.save(artist.to())
        )
    }

    fun update(artist: ArtistDto): ArtistDto {
        if (!existById((artist.id))) {
            throw Exception("artistId=${artist.id} does not exists.")
        }

        return ArtistDto.from(
            artistRepository.save(artist.to())
        )
    }
}
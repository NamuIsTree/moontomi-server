package com.moontomi.server.core.album

import com.moontomi.server.core.artist.ArtistService
import com.moontomi.server.core.genre.GenreService
import com.moontomi.server.core.image.ImageService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AlbumService(
    private val albumRepository: AlbumRepository,
    private val artistService: ArtistService,
    private val imageService: ImageService,
    private val genreService: GenreService
) {
    fun findAll(): List<AlbumDto> {
        return albumRepository.findAll().map {
            AlbumDto.from(
                album = it,
                genres = it.genres.map { genre -> genreService.findById(genre) }
            )
        }
    }

    fun findById(id: Int): AlbumDto {
        val album = albumRepository.findByIdOrNull(id) ?: throw Exception("albumId=$id does not exist.")
        val genres = album.genres.map { genreService.findById(it) }

        return AlbumDto.from(
            album = album,
            genres = genres
        )
    }

    fun existsById(id: Int): Boolean {
        return albumRepository.existsById(id)
    }

    fun insert(request: AlbumCreationRequest): AlbumDto {
        if (!imageService.existsById(request.imageId)) {
            throw Exception("imageId=${request.imageId} does not exist.")
        }

        return AlbumDto.from(
            albumRepository.save(request.to(
                artist = artistService.findById(request.artistId),
                genres = request.genreIds.map { genreService.findById(it) }
            )),
            genres = request.genreIds.map { genreService.findById(it) }
        )
    }

    fun update(album: AlbumDto): AlbumDto {
        if (!existsById(album.id)) {
            throw Exception("albumId=${album.id} does not exists")
        }

        return AlbumDto.from(
            album = albumRepository.save(album.to()),
            genres = album.genres
        )
    }
}
